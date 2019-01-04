# Belajar elasticsearch with Springboot

## Elasticsearch stack

- kibana: analitic & visualitation as diagram
- logstash: data processing pipeline (compress & uncompress data)
- x-pack: additional package for elasticsearch
    - security: connected to LDAP, active directory and many more
    - monitoring: CPU, Memory usage
    - alert: notification on event example memory usage has been 90%
    - reporting: generate a report to pdf or csv
    - machine learning: 
    - graph: related item, similarity, 
    - elasticsearch SQL: convert sql to document
- beats: agent for sent data to logstash

## Elasticsearch

- node is a server contain data
- cluster is collection of nodes
- document are the json format, and every document have an id for autogenerated or manualy
- document store into index

## Example query for elasticsearch

```http request
# creating an index
PUT /products?pretty


# add document a product with random id
POST /products/default
{
  "name": "Macbook Pro 13\"",
  "price": 28000000,
  "qty": 10
}

# add document a product with my own id
POST /products/default/1
{
  "name": "Lenovo thinkpad 13\"",
  "price": 12000000,
  "qty": 1
}

# get document by id
GET /products/default/1

# get agregate count rows of documents
GET /products/default/_count

# replace document by id
PUT /products/default/1
{
  "name": "Asus Republic Of Gamming",
  "price": 25000000
}

# update document by id
POST /products/default/1/_update
{
  "doc": {
    "name": "Asus ROG"
  }
}
```

## Meta filed

- `_index`
- `_id`
- `_source` is original json
- `_field_names`
- `_routing`
- `_version`
- `_meta`


