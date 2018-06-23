<#assign title="home">
<#assign isHome="active">
<#include "header.ftl">

<div class="container">


    <h2>浏览列表</h2>

    <div class="row">
        <div class="col-md-6">
            <table class="table">
                <tr>
                    <th>名称</th>
                    <th>地址</th>
                </tr>

            <#list websites as site>
                <#if site.readyToSee == true>
                    <tr>
                        <td>${site.name!}</td>
                        <td><a onclick="addView('${site.id}')" href="${site.url!}" target="_blank">${site.showUrl!}</a></td>
                    </tr>
                </#if>
            </#list>
            </table>
        </div>
        <div class="col-md-6">

            <p>
                <a class="btn btn-default" role="button" data-toggle="collapse" href="#collapseExample" aria-expanded="false"
                   aria-controls="collapseExample">
                    显示剩余 <span class="caret"></span>
                </a>

            </p>

            <div class="collapse" id="collapseExample">
                <table class="table">
                    <tr>
                        <th>名称</th>
                        <th>地址</th>
                        <th>剩余时间</th>
                    </tr>

                <#list websites as site>
                    <#if site.readyToSee != true>
                        <tr>
                            <td>${site.name!}</td>
                            <td>${site.showUrl!}</td>
                            <td>${site.leftTime!}</td>
                        </tr>
                    </#if>
                </#list>
                </table>
            </div>
        </div>
    </div>




</div>

<#include "footer.ftl">
<script type="text/javascript">
    function addView(siteId) {
        $.post("addView", {id: siteId}, function (data) {
            location.reload();
        });
    }
</script>