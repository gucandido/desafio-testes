# desafio_quality

### Repositório da solução do desafio quality

Como pré requisito, para que uma propriedade possa ser cadastrada é necessário que antes haja cadastrado o bairro correspondente, a seguir estão os métodos dos endpoints disponibilizados para este fim:

#### 1. Cadastro dos bairros

<p><code>Method: POST</code><br><code>Sign: http://localhost:8080/district</code></p>
<pre>
<code><span style="font-size: medium">Body:</span> </code>

    {
        "district_name":"xurupita village",
        "value_district_m2":5
    }


<code><span style="font-size: medium">Response (Status: 201 - Created):</span></code>

    {
        "id": 0,
        "district_name": "xurupita village",
        "value_district_m2": 5
    }

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>id</td><td>int</td><td>id do bairro após ser cadastrado</td></tr>
<tr style="text-align: left"><td>district_name</td><td>String</td><td>Nome do bairro a ser cadastrado</td></tr>
<tr style="text-align: left"><td>value_district_m2</td><td>double</td><td>Valor por metro quadrado no bairro</td></tr>
</table>
</pre>

#### 2. listagem dos bairros 

Todos os bairros em uma lista:

<p><code>Method: GET</code><br><code>Sign: http://localhost:8080/district</code></p>
<pre>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    [
        {
            "id": 0,
            "district_name": "xurupita village",
            "value_district_m2": 5
        }
    ]

</pre>

Um único bairro através do id:

<p><code>Method: GET</code><br><code>Sign: http://localhost:8080/district/{id}</code></p>
<pre>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    {
        "id": 0,
        "district_name": "xurupita village",
        "value_district_m2": 5
    }

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>id</td><td>int</td><td>id do bairro após ser cadastrado</td></tr>
<tr style="text-align: left"><td>district_name</td><td>String</td><td>Nome do bairro a ser cadastrado</td></tr>
<tr style="text-align: left"><td>value_district_m2</td><td>double</td><td>Valor por metro quadrado no bairro</td></tr>
</table>
</pre>

#### 3. Excluir um bairro

<p><code>Method: DELETE</code><br><code>Sign: http://localhost:8080/district/{id}</code></p>
<pre>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    {
        "message": "Bairro deletado com sucesso"
    }

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>id</td><td>int</td><td>Id do bairro a ser excluído</td></tr>
<tr style="text-align: left"><td>message</td><td>String</td><td>Mensagem de retorno</td></tr>
</table>
</pre>

Após o cadastro do bairro ao qual a propriedade pertence, é possível cadastrar a propriedade.
A seguir estão os métodos dos endpoints disponibilizados para este fim: 

#### 4. Cadastro das propriedades

<p><code>Method: POST</code><br><code>Sign: http://localhost:8080/property</code></p>
<pre>
<code><span style="font-size: medium">Body:</span> </code>

    {
        "prop_name":"CafofoDoOsama",
        "district_id":0,
        "rooms":[
            {
                "room_name":"Quarto",
                "room_width":2.0,
                "room_length":3.0
            },
            {
                "room_name":"Cozinha",
                "room_width":4.0,
                "room_length":3.0
            },
            {
                "room_name":"GuaritaDoSnipper",
                "room_width":1.0,
                "room_length":1.5
            }
        ]
    }


<code><span style="font-size: medium">Response (Status: 201 - Created):</span></code>

    {
        "id": 0,
        "prop_name": "CafofoDoOsama",
        "district_id": 0,
        "rooms": [
            {
                "room_name": "Quarto",
                "room_width": 2.0,
                "room_length": 3.0,
                "room_area": 6.0
            },
            {
                "room_name": "Cozinha",
                "room_width": 4.0,
                "room_length": 3.0,
                "room_area": 12.0
            },
            {
                "room_name": "GuaritaDoSnipper",
                "room_width": 1.0,
                "room_length": 1.5,
                "room_area": 1.5
            }
        ],
        "prop_value": 97.5
    }

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>id</td><td>int</td><td>id da propriedade após ser cadastrada</td></tr>
<tr style="text-align: left"><td>prop_name</td><td>String</td><td>Nome da propriedade</td></tr>
<tr style="text-align: left"><td>district_id</td><td>int</td><td>id do bairro ao qual a propriedade pertence</td></tr>
<tr style="text-align: left"><td>rooms</td><td>Object List</td><td>lista de cômodos da propriedade</td></tr>
<tr style="text-align: left"><td>room_name</td><td>String</td><td>Nome do cômodo</td></tr>
<tr style="text-align: left"><td>room_width</td><td>double</td><td>Largura do cômodo</td></tr>
<tr style="text-align: left"><td>room_length</td><td>double</td><td>Comprimento do cômodo</td></tr>
<tr style="text-align: left"><td>room_area</td><td>double</td><td>Área do cômodo (calculado automaticamente)</td></tr>
<tr style="text-align: left"><td>prop_value</td><td>double</td><td>Valor da propriedade (calculado automaticamente com base no valor por metro quadrado do bairro)</td></tr>
</table>
</pre>

#### 5. Listagem das propriedades

Todas as propriedades em uma lista:

<p><code>Method: GET</code><br><code>Sign: http://localhost:8080/property</code></p>
<pre>

<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    [
        {
            "id": 0,
            "prop_name": "CafofoDoOsama",
            "district_id": 0,
            "rooms": [
                {
                    "room_name": "Quarto",
                    "room_width": 2.0,
                    "room_length": 3.0,
                    "room_area": 6.0
                },
                {
                    "room_name": "Cozinha",
                    "room_width": 4.0,
                    "room_length": 3.0,
                    "room_area": 12.0
                },
                {
                    "room_name": "GuaritaDoSnipper",
                    "room_width": 1.0,
                    "room_length": 1.5,
                    "room_area": 1.5
                }
            ],
            "prop_value": 97.5
        }
    ]

</pre>

Uma única propriedade através do id:

<p><code>Method: GET</code><br><code>Sign: http://localhost:8080/property/{id}</code></p>
<pre>

<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    {
        "id": 0,
        "prop_name": "CafofoDoOsama",
        "district_id": 0,
        "rooms": [
            {
                "room_name": "Quarto",
                "room_width": 2.0,
                "room_length": 3.0,
                "room_area": 6.0
            },
            {
                "room_name": "Cozinha",
                "room_width": 4.0,
                "room_length": 3.0,
                "room_area": 12.0
            },
            {
                "room_name": "GuaritaDoSnipper",
                "room_width": 1.0,
                "room_length": 1.5,
                "room_area": 1.5
            }
        ],
        "prop_value": 97.5
    }

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>id</td><td>int</td><td>id da propriedade após ser cadastrada</td></tr>
<tr style="text-align: left"><td>prop_name</td><td>String</td><td>Nome da propriedade</td></tr>
<tr style="text-align: left"><td>district_id</td><td>int</td><td>id do bairro ao qual a propriedade pertence</td></tr>
<tr style="text-align: left"><td>rooms</td><td>Object List</td><td>lista de cômodos da propriedade</td></tr>
<tr style="text-align: left"><td>room_name</td><td>String</td><td>Nome do cômodo</td></tr>
<tr style="text-align: left"><td>room_width</td><td>double</td><td>Largura do cômodo</td></tr>
<tr style="text-align: left"><td>room_length</td><td>double</td><td>Comprimento do cômodo</td></tr>
<tr style="text-align: left"><td>room_area</td><td>double</td><td>Área do cômodo (calculado automaticamente)</td></tr>
<tr style="text-align: left"><td>prop_value</td><td>double</td><td>Valor da propriedade (calculado automaticamente com base no valor por metro quadrado do bairro)</td></tr>
</table>
</pre>

#### 6. Excluir uma propriedade
<p><code>Method: DELETE</code><br><code>Sign: http://localhost:8080/property/{id}</code></p>
<pre>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    {
        "message": "Propriedade deletada com sucesso"
    }

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>id</td><td>int</td><td>Id da propriedade a ser excluída</td></tr>
<tr style="text-align: left"><td>message</td><td>String</td><td>Mensagem de retorno</td></tr>
</table>
</pre>

Após o cadastro dos bairros e propriedades é possível utilizar os endpoints que cumprem as US.

#### 7. Retorno da área total de uma propriedade - US-0001
<p><code>Method: GET</code><br><code>Sign: http://localhost:8080/property/{id}/area</code></p>
<pre>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    {
        "message": "A área total da propriedade é: 19.5"
    }

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>id</td><td>int</td><td>Id da propriedade</td></tr>
<tr style="text-align: left"><td>message</td><td>String</td><td>Mensagem de retorno</td></tr>
</table>
</pre>

#### 8. Retorno do valor de uma propriedade - US-0002
<p><code>Method: GET</code><br><code>Sign: http://localhost:8080/property/{id}/value</code></p>
<pre>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    {
        "message": "O valor da propriedade é: 97.5"
    }

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>id</td><td>int</td><td>Id da propriedade</td></tr>
<tr style="text-align: left"><td>message</td><td>String</td><td>Mensagem de retorno</td></tr>
</table>
</pre>

#### 9. Retorno do maior cômodo na propriedade - US-0003
<p><code>Method: GET</code><br><code>Sign: http://localhost:8080/property/{id}/room/biggest</code></p>
<pre>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    {
        "room_name": "Cozinha",
        "room_width": 4.0,
        "room_length": 3.0,
        "room_area": 12.0
    }

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>id</td><td>int</td><td>Id da propriedade</td></tr>
<tr style="text-align: left"><td>room_name</td><td>String</td><td>Nome do cômodo</td></tr>
<tr style="text-align: left"><td>room_width</td><td>double</td><td>Largura do cômodo</td></tr>
<tr style="text-align: left"><td>room_length</td><td>double</td><td>Comprimento do cômodo</td></tr>
<tr style="text-align: left"><td>room_area</td><td>double</td><td>Área do cômodo</td></tr>
</table>
</pre>

#### 9. Retorno da área de cada cômodo - US-0004
<p><code>Method: GET</code><br><code>Sign: http://localhost:8080/property/{id}/room/area</code></p>
<pre>
<code><span style="font-size: medium">Response (Status: 202 - Accepted):</span></code>

    [
        {
            "room_name": "Quarto",
            "room_width": 2.0,
            "room_length": 3.0,
            "room_area": 6.0
        },
        {
            "room_name": "Cozinha",
            "room_width": 4.0,
            "room_length": 3.0,
            "room_area": 12.0
        },
        {
            "room_name": "GuaritaDoSnipper",
            "room_width": 1.0,
            "room_length": 1.5,
            "room_area": 1.5
        }
    ]

</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>id</td><td>int</td><td>Id da propriedade</td></tr>
<tr style="text-align: left"><td>room_name</td><td>String</td><td>Nome do cômodo</td></tr>
<tr style="text-align: left"><td>room_width</td><td>double</td><td>Largura do cômodo</td></tr>
<tr style="text-align: left"><td>room_length</td><td>double</td><td>Comprimento do cômodo</td></tr>
<tr style="text-align: left"><td>room_area</td><td>double</td><td>Área do cômodo</td></tr>
</table>
</pre>