java-oracle-client
==================

Oracle client implemented in JAVA using Spring JDBC Template

To use the project you need to download the Oracle driver from:

```
http://www.oracle.com/technetwork/database/features/jdbc/
```

and install it in your local Maven repository, ie:

```
mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc14 -Dversion=10.2.0.5 -Dpackaging=jar -Dfile=ojdbc14.jar -DgeneratePom=true
```
