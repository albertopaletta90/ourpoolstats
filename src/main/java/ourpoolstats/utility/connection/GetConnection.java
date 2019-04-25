package ourpoolstats.utility.connection;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class GetConnection {

		private DataSource dataSource;
		private JdbcTemplate jdbcTemplateObject;
		
		public DataSource getDataSource() {
			return dataSource;
		}
		
		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
			this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
		}
		public JdbcTemplate getJdbcTemplateObject() {
			return jdbcTemplateObject;
		}
		public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
			this.jdbcTemplateObject = jdbcTemplateObject;
		}

}
