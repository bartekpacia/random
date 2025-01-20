```shell
docker run --name rudy-postgres -e POSTGRES_PASSWORD=secret \
  --mount type=volume,src=rudy-postgres-data,dst=/Users/bartek/postgresdata \
  --mount type=bind,src=.,dst=/docker-entrypoint-initdb.d \
  -p 5432:5432 \
  -d postgres:17.0-alpine3.20
```

### Queries

Select places that were visited 2 or more times:

```
SELECT places.name
FROM places
WHERE places.id IN (SELECT visits.place_id FROM visits GROUP BY visits.place_id HAVING COUNT(*) >= 2)
```

Select places that user 'barpac02@gmail.com' has visited:

```
SELECT places.name, users.name
FROM visits
         JOIN places ON places.id = visits.place_id
         JOIN users ON users.id = visits.user_id
WHERE users.email = 'barpac02@gmail.com'
```
