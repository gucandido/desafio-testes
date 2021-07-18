# desafio_quality

### Repositório da solução do desafio quality

A seguir está descrito o passo a passo para configuracao e teste do desafio:

#### 1. Cadastro dos bairros

<p><code>Method: POST</code><br><code>Sign: http://localhost:8080/district</code></p>
<pre>
<code><span style="font-size: medium">Body(Vendedor):</span> </code>

    {
        "district_name":"pobreta village",
        "value_district_m2":5
    }


<code><span style="font-size: medium">Response (Status: 201 - Created):</span></code>

    {
        "district_name":"pobreta village",
        "value_district_m2":5
    }
</pre>

<pre>
<table>
<tr><th colspan="3">Parâmetros</th></tr>
<tr style="text-align: left"><th>Parâmetro</th><th>Tipo</th><th>Descrição/Exemplo</th></tr>
<tr style="text-align: left"><td>district_name</td><td>String</td><td>Nome do bairro a ser cadastrado</td></tr>
<tr style="text-align: left"><td>value_district_m2</td><td>double</td><td>Valor por metro quadrado no bairro</td></tr>
</table>
</pre>