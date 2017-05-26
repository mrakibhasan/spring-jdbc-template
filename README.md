# spring-jdbc-template

JDBC template is one of the powerful mechanishm for doing the database operations.
It internally uses JDBC api, but eliminates a lot of problems of JDBC API.

      The problems of JDBC API are as follows:

      We need to write a lot of code before and after executing the query, such as creating connection, statement, closing resultset, connection etc.
      We need to perform exception handling code on the database logic.
      We need to handle transaction.
      Repetition of all these codes from one to another database logic is a time consuming task.
      
      
      Advantage of Spring JdbcTemplate

      Spring JdbcTemplate eliminates all the above mentioned problems of JDBC API.
      It provides you methods to write the queries directly, so it saves a lot of work and time.
      
      Spring framework provides following approaches for JDBC database access:

            JdbcTemplate
            NamedParameterJdbcTemplate
            SimpleJdbcTemplate
            SimpleJdbcInsert and SimpleJdbcCall
            
        Here, in this project NamedParameterJdbcTemplate is used becuase NamedParameterJdbcTemplate allows you to assign names to the parameter placeholders 
        and pass in a map so the template can match the map names to the placeholders. Moreover, JdbcTemplate is error prone
        ince the order of "?" placeholders present in query and order of parameters you are passing through either array or direct setting is matter
        
       
