<#assign title="manage">
<#assign isManage="active">
<#include "header.ftl">

<div class="container">


    <h2>全部列表</h2>

    <table class="table">
        <tr>
            <th>id</th>
            <th>名称</th>
            <th>地址</th>
            <th>间隔</th>
            <th>上次查看</th>
            <th>操作</th>
        </tr>

    <#list websites as site>
        <tr>
            <td>${site.id}</td>
            <td>${site.name!}</td>
            <td><a href="${site.url!}" target="_blank">${site.showUrl!}</a></td>
            <td>${site.timeMargin!}</td>
            <td>${(site.lastSeen?string["MM-dd HH:mm"])!}</td>
            <td><a class="btn btn-danger" href="del?id=${site.id}" role="button">删除</a></td>
        </tr>
    </#list>
    </table>

    <a class="btn btn-primary" href="toAdd" role="button">添加</a>
</div>

<#include "footer.ftl">