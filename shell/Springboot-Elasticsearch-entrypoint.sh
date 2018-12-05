#!/bin/sh
echo "********************************************************"
echo "Wait for elasticsearch to be available"
echo "********************************************************"

while ! nc -z $ELASTICSEARCH_STATUS_HOST $ELASTICSEARCH_STATUS_PORT; do
  printf 'elasticsearch is still not available. Retrying...\n'
  sleep 3
done

echo "********************************************************"
echo "Starting myapp"
echo "********************************************************"

java -Dserver.port=$SERVER_PORT \
     -Dspring.data.elasticsearch.cluster-name=$ELASTICSEARCH_CLUSTER_NAME \
     -Dspring.data.elasticsearch.cluster-nodes=$ELASTICSEARCH_CLUSTER_NODE \
     -Dspring.data.elasticsearch.repositories.enabled=$ELASTICSEARCH_REPOSITORIES_ENABLE \
     -jar /opt/lib/springboot-elasticsearch-0.0.1-SNAPSHOT.jar