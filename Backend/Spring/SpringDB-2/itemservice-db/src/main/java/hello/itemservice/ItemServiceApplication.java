package hello.itemservice;

import hello.itemservice.config.*;
import hello.itemservice.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


// @Import(MemoryConfig.class)
// @Import(JdbcTemplateV1Config.class)
// @Import(JdbcTemplateV2Config.class)
// @Import(JdbcTemplateV3Config.class)
@Import(MyBatisConfig.class)
// @Import(JpaConfig.class)
// @Import(SpringDataJpaConfig.class)
// @Import(QueryDslConfig.class)
// @Import(V2Config.class)
@Slf4j
@SpringBootApplication(scanBasePackages = "hello.itemservice.web")
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	@Bean
	@Profile("local")
	public TestDataInit testDataInit(ItemRepository itemRepository) {
		return new TestDataInit(itemRepository);
	}

/*	@Bean
	@Profile("test")
	public DataSource dataSource() {
		// 임베디드 모드 DB 사용하기(h2)
		log.info("메모리 데이터베이스 초기화");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1"); // 데이터베이스 커넥션이 끊어지면 데이터베이스도 종료되는데, 그것을 방지
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;

		//org.springframework.jdbc.BadSqlGrammarException: PreparedStatementCallback; bad SQL grammar []; nested exception is org.h2.jdbc.JdbcSQLSyntaxErrorException: Table "ITEM" not found; SQL statement:
		//INSERT INTO item () VALUES() [42102-200]

		//2022-09-18 23:40:19.590 DEBUG 9712 --- [           main] o.s.j.d.DriverManagerDataSource          : Creating new JDBC DriverManager Connection to [jdbc:h2:mem:db;DB_CLOSE_DELAY=-1]
		//2022-09-18 23:40:19.679 DEBUG 9712 --- [           main] o.s.jdbc.datasource.DataSourceUtils      : Fetching JDBC Connection from DataSource
		//2022-09-18 23:40:19.679 DEBUG 9712 --- [           main] o.s.j.d.DriverManagerDataSource          : Creating new JDBC DriverManager Connection to [jdbc:h2:mem:db;DB_CLOSE_DELAY=-1]
		//2022-09-18 23:40:19.679 DEBUG 9712 --- [           main] o.s.jdbc.datasource.init.ScriptUtils     : Executing SQL script from URL
		//2022-09-18 23:40:19.681 DEBUG 9712 --- [           main] o.s.jdbc.datasource.init.ScriptUtils     : 0 returned as update count for SQL: drop table if exists item CASCADE
		//2022-09-18 23:40:19.686 DEBUG 9712 --- [           main] o.s.jdbc.datasource.init.ScriptUtils     : 0 returned as update count for SQL: create table item ( id bigint generated by default as identity, item_name varchar(10), price integer, quantity integer, primary key (id) )
	}*/

	//테스트에 프로퍼티에 테스트 관련 디비연결 설정정보가 없다면, 스프링부트에서 자동으로 임베디드 모드로 실행해준다. (url 경로가 mem)
	//2022-09-18 23:45:47.802 DEBUG 9961 --- [           main] o.s.jdbc.support.JdbcTransactionManager  : Rolling back JDBC transaction on Connection [HikariProxyConnection@263103706 wrapping conn0: url=jdbc:h2:mem:e4e8682e-be0d-4ece-b061-d306c8e8e8e6 user=SA]
	//2022-09-18 23:45:47.803 DEBUG 9961 --- [           main] o.s.jdbc.support.JdbcTransactionManager  : Releasing JDBC Connection [HikariProxyConnection@263103706 wrapping conn0: url=jdbc:h2:mem:e4e8682e-be0d-4ece-b061-d306c8e8e8e6 user=SA] after transaction
}
