<!DOCTYPE html>
<html>
    <head>
        <title>websites</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css" />
        </head>
    <body>
        <h2>List of websites</h2>
        
        <table>
            <tr>
                <th>Id</th>  
                <th>Name</th>  
                <th>url</th>
                <th>timeMargin</th>
                <th>lastSeen</th>
            </tr>

            <#list websites as site>
                <tr>
                    <td>${site.id}</td>
                    <td>${site.name}</td>
                    <td>${site.url}</td>
                    <td>${site.timeMargin}</td>
                    <td>${site.lastSeen}</td>
                </tr>
            </#list>        
        </table>                
    </body>
</html>
