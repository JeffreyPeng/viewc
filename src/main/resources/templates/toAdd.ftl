<#assign title="add">
<#include "header.ftl">

<div class="container">

    <h2>add website</h2>

    <form action="/add" method="post">
        <div class="form-group">
            <label for="exampleInputName">显示名称</label>
            <input type="name" name="name" class="form-control" id="exampleInputName" placeholder="">
        </div>
        <div class="form-group">
            <label for="exampleInputUrl">网页地址</label>
            <input type="url" name="url" class="form-control" id="exampleInputUrl" placeholder="">
        </div>
        <div class="form-group">
            <label for="exampleInputTimeMargin">频率间隔（小时）</label>
            <input type="number" name="timeMargin" min="1" value="2" class="form-control" id="exampleInputTimeMargin"
                   placeholder="TimeMargin">
        </div>
        <button type="submit" class="btn btn-primary">提交</button>
    </form>

</div>

<#include "footer.ftl">