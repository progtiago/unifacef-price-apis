# unifacef-price-apis
Aplicação para cadastro de preços a ser utilizada na disciplina de Apis Rest com Java e Spring da UNIFACEF. 

## Exercício

Criar serviços que permitam o cadastro de Produto/Preço/Estoque em microsserviços apartados e cada qual com suas respectivas validações.
Também deverá ser criado um microsserviço de agregação onde os payloads oriundos dos microsserviços especialistas são agregados.

### Contratos:

#### Apis de produto:

- POST /api/v1/products

'''
{
  "code": "String",
  "name": "String",
  "description": "String",
  "brand": "String",
  "images": [
    "String"
  ],
  "attributes": [
    {
      "key": "String",
      "value": "String"
    }
  ]
}

'''


- PUT /api/v1/products/{code}

'''
{
  "name": "String",
  "description": "String",
  "brand": "String",
  "images": [
    "String"
  ],
  "attributes": [
    {
      "key": "String",
      "value": "String"
    }
  ]
}

'''

- GET /api/v1/products/{code}

'''
{
  "code": "String",
  "name": "String",
  "description": "String",
  "brand": "String",
  "images": [
    "String"
  ],
  "attributes": [
    {
      "key": "String",
      "value": "String"
    }
  ],
  "createdDate": "LocalDateTime",
  "lastModifiedDate": "LocalDateTime"
}
'''

- GET /api/v1/products

'''
{
  "items": [
    {
      "code": "String",
      "name": "String",
      "description": "String",
      "brand": "String",
      "images": [
        "String"
      ],
      "attributes": [
        {
          "key": "String",
          "value": "String"
        }
      ],
      "createdDate": "LocalDateTime",
      "lastModifiedDate": "LocalDateTime"
    }
  ],
  "page": "Integer",
  "size": "Integer",
  "totalElements": "Integer",
  "totalPages": "Integer"
}
'''

#### Apis de preço:

- POST /api/v1/products/{productCode}/prices

'''
{
  "from": "Double",
  "to": "Double"
}
'''


- PUT /api/v1/products/{productCode}/prices

'''
{
  "from": "Double",
  "to": "Double"
}
'''

- GET /api/v1/products/{productCode}/prices

'''
{
  "productCode": "String",
  "from": "Double",
  "to": "Double",
  "createdDate": "LocalDateTime",
  "lastModifiedDate": "LocalDateTime"
}
'''


#### Apis de estoque:

- POST /api/v1/products/{productCode}/inventories

'''
{
  "position": "Integer"
}
'''

- PUT /api/v1/products/{productCode}/inventories

'''
{
  "position": "Integer"
}
'''

- GET /api/v1/products/{productCode}/inventories

'''
{
  "productCode": "String",
  "position": "Integer",
  "createdDate": "LocalDateTime",
  "lastModifiedDate": "LocalDateTime"
}
'''

## A solução



