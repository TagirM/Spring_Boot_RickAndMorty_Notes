<#import "blocks/template.ftlh" as t>
<@t.template>
    <h3 style="text-align: left">Поиск героев по имени</h3><hr>
    <form action="/rickandmorty" method="get">
        <div class="form-row">
            <div class="form-group col-md-10">
                <input type="text" name="search" <#if search??>value="${search}"</#if> class="form-control"
                       id="search">
            </div>
            <button style="width: 100%" type="submit" class="btn btn-dark">Поиск</button>
        </div>
    </form>
    <hr>
    <div class="card-columns">
        <#list results as result>
            <a href="/rickandmorty/${result.id}" class="product-link">
                <div class="card text-white bg-dark my-3 product">
                    <img src="${result.image}"
                         class="card-img-top">
                    <div class="card-body">
                        <h5 class="card-title">Name: ${result.name}</h5>
                        <p class="card-text">Status: ${result.status}</p>
                        <p class="card-text">Type: ${result.type}</p>
                        <p class="card-text">Gender: ${result.gender}</p>
                    </div>
                    <div class="card-footer">
                        Species: ${result.species}
                    </div>
                </div>
            </a>
        <#else>
            <h1 style="text-align: center">Не найдено</h1>
        </#list>
    </div>
</@t.template>