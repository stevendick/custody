dataSource {
    pooled = true
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            driverClassName = "org.h2.Driver"
            username = "sa"
            password = ""
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    test {
        dataSource {
            driverClassName = "net.sourceforge.jtds.jdbc.Driver"
            dialect = org.hibernate.dialect.SQLServer2008Dialect
            username = "sa"
            password = "sa2008"
            url = "jdbc:jtds:sqlserver://localhost:1433/custody"
        }
    }
    production {
        dataSource {
            driverClassName = "net.sourceforge.jtds.jdbc.Driver"
            dialect = org.hibernate.dialect.SQLServer2008Dialect
            username = "infonic_aws_sa"
            password = "dqP66MHXuSSgrAFwdFPF"
            url = "jdbc:jtds:sqlserver://custody.czvf4joffama.us-east-1.rds.amazonaws.com:1433/custody"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
