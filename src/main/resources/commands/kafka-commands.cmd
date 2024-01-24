.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic registeralumni

.\bin\windows\kafka-topics.bat -create --zookeeper localhost:2181 -replication-factor 1 -partitions 1 -topic registeralumni
.\bin\windows\kafka-topics. -create --zookeeper localhost:2181 -replication-factor 1 -partitions 1 -topic registeralumni

kafka-topics -zookeeper localhost:2181 -topic registeralumni -create

kafka-topics.bat --bootstrap-server localhost:2181 -topic registeralumni --create --partitions 1 --replication-factor 1