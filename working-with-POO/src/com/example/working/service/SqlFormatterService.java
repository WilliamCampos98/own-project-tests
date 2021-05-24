package com.example.working.service;

public class SqlFormatterService {
	/* Parametros usados en las consultas */
	Integer oficRegi = 301;
	Integer selectAnio = 2020;
	Integer codi_ofic_regi = 171;
	String fechaSql = "01/03/2021";

	public void sqlFormat() {
		/*
		 * Query para obtener los datos de las gráficas de barras horizontales de tipo
		 * de partidas
		 */
		StringBuffer sql1 = new StringBuffer();
		sql1.append("select nomb_tipo_part ");
		sql1.append(", sum(con_imag) con_imag ");
		sql1.append(", sum(sin_imag_actu) sin_imag_actu ");
		sql1.append("from ( ");
		sql1.append("    select nomb_tipo_part ");
		sql1.append("           , 0 as con_imag ");
		sql1.append("           , 0 as sin_imag_actu ");
		sql1.append("      from catalogo.tipo_part tp ");
		sql1.append("     where tp.esta_tipo_part = 1 ");
		sql1.append("union all ");
		sql1.append("    select tp.nomb_tipo_part");
		sql1.append("           , sum(case when p.esta_imag_part = 1 then 1 else 0 end) con_imag ");
		sql1.append("           , sum(case when p.esta_imag_part <> 1 then 1 else 0 end) sin_imag_actu ");
		sql1.append("      from registro.part p ");
		sql1.append(
				"        JOIN registro.libr l ON (l.codi_libr = p.codi_libr and l.codi_ofic_regi= p.codi_ofic_regi) ");
		sql1.append("        JOIN catalogo.tipo_part tp ON (l.codi_tipo_part = tp.codi_tipo_part) ");
		sql1.append("        JOIN catalogo.orig_part op ON (p.codi_orig_part = op.codi_orig_part) ");
		sql1.append("      where l.anio_libr = " + selectAnio + "and op.filt_orig_part = 1 ");
		// sql.append(complemento);
		if (oficRegi != null) {
			sql1.append("and p.codi_ofic_regi = ");
			sql1.append(oficRegi);
		}
		sql1.append("      group by tp.codi_tipo_part, tp.nomb_tipo_part");
		sql1.append("      order by 1 ");
		sql1.append(") p");
		sql1.append(" group by nomb_tipo_part");
		// System.out.println(sql1);
		/*************************************************************/
		/* Query para cards de 4 datos de tipos de partidas */
		StringBuffer sql2 = new StringBuffer();
		sql2.append(
				"select tp.codi_tipo_part, tp.nomb_tipo_part, coalesce(q.cantidad,0) from catalogo.tipo_part tp left join ( ");
		sql2.append(
				"select l.codi_tipo_part,count(p.codi_part) cantidad from registro.part p join registro.libr l on p.codi_libr = l.codi_libr and p.codi_ofic_regi = l.codi_ofic_regi ");
		sql2.append("join catalogo.orig_part op on op.codi_orig_part = p.codi_orig_part ");
		sql2.append("where l.anio_libr =" + selectAnio + " and op.filt_orig_part = 1 ");
		if (oficRegi != null) {
			sql2.append("and p.codi_ofic_regi =" + oficRegi + " ");
		}
		sql2.append(
				"group by l.codi_tipo_part) q on q.codi_tipo_part = tp.codi_tipo_part order by q.codi_tipo_part asc");
		// System.out.println(sql2);
		/*************************************************************/
		/* Query para datatable historico */
		String sql3 = "select  " + "     l.codi_tipo_part, t.nomb_tipo_part, "
				+ "     count(CASE WHEN op.filt_orig_part = 1 THEN 1 END ) as total_part_year, "
				+ "     count(CASE WHEN op.filt_orig_part <> 1 THEN 1 END ) as total_part_hist_year, "
				+ "     count(CASE WHEN (op.filt_orig_part <> 1) OR (op.filt_orig_part = 1) THEN 1 END ) as total_part "
				+ "from registro.part p join registro.libr l on p.codi_libr = l.codi_libr and p.codi_ofic_regi = l.codi_ofic_regi "
				+ "     left join catalogo.orig_part op on op.codi_orig_part = p.codi_orig_part  "
				+ "     left join  catalogo.tipo_part t on l.codi_tipo_part = t.codi_tipo_part "
				+ " where  p.codi_ofic_regi = %d and (l.anio_libr = " + selectAnio
				+ " or EXTRACT(YEAR FROM fech_migr) = " + selectAnio + ") "
				+ " group by  l.codi_tipo_part, t.nomb_tipo_part " + " order by l.codi_tipo_part";
		sql3 = String.format(sql3, codi_ofic_regi);
		// System.out.println(sql3);
		/*************************************************************/
		/* Query para obtener los datos de los gráficos de pastel */
		StringBuffer sql4 = new StringBuffer();

		sql4.append("select concat(' ', nomb_tipo_part), sum(total_part) ");
		sql4.append("  from ( ");
		sql4.append("         select t.nomb_tipo_part, count(*) as total_part ");
		sql4.append("           from registro.part p ");
		sql4.append(
				"            join registro.libr l on p.codi_libr = l.codi_libr and p.codi_ofic_regi = l.codi_ofic_regi ");
		sql4.append("            left join catalogo.tipo_part t on l.codi_tipo_part = t.codi_tipo_part ");
		sql4.append("          where t.esta_tipo_part = 1  ");
		sql4.append("            and l.anio_libr = " + selectAnio + " ");
		sql4.append("            and fech_migr = '" + fechaSql + "'");
		if (oficRegi != null) {
			sql4.append("        and p.codi_ofic_regi =" + oficRegi + " ");
		}
		sql4.append("            group by t.nomb_tipo_part ");
		sql4.append("union ");
		sql4.append("        select t.nomb_tipo_part, 0 as total_part ");
		sql4.append("          from catalogo.tipo_part t ");
		sql4.append("         where t.esta_tipo_part = 1 ");
		sql4.append(") tsv ");
		sql4.append("group by nomb_tipo_part ");
		// System.out.println(sql4);
	}
}
