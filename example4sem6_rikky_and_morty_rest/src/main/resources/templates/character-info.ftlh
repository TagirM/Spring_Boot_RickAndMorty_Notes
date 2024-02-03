<#import "blocks/template.ftlh" as t>
<@t.template>
    <div class="container cards-box-char">
        <hr>
        <div class="card-columns">
            <div class="card text-white bg-dark my-3 product">
                <img src="${result.image}"
                     class="card-img-top">
                <div class="card-body">
                    <h5 class="card-title">Name: ${result.name}</h5>
                    <p class="card-text">Status: ${result.status}</p>
                    <p class="card-text">Type: ${result.type}</p>
                    <p class="card-text">Gender: ${result.gender}</p>
                    <p class="card-text">Created at ${result.created}</p>
                </div>
                <div class="card-footer">
                    Species: ${result.species}
                </div>
            </div>
        </div>
    </div>
</@t.template>