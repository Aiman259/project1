

CONTAINER_NAME="mongodb" 
DB_NAME="project1_db"

echo "Memulakan proses reset database..."

docker exec -i $CONTAINER_NAME mongosh $DB_NAME --eval "db.courses.drop()"


docker cp seed/courses.json $CONTAINER_NAME:/tmp/courses.json
docker exec -i $CONTAINER_NAME mongoimport --db $DB_NAME --collection courses --file /tmp/courses.json --jsonArray

echo "Data telah berjaya diimport!"

echo "Jumlah kursus dalam database:"
docker exec -i $CONTAINER_NAME mongosh $DB_NAME --eval "db.courses.countDocuments()"