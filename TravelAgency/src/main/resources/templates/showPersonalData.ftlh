<!DOCTYPE html>
<html>
    <head>
        <title>PersonalData</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>
    <body>
        <h2>List of personal data</h2>

        <table>
            <tr>
                <th>Id</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Phone</th>
            </tr>

            <#list cities as city>
                <tr>
                    <td>${personal_data.id}</td>
                    <td>${personal_data.firstname}</td>
                    <td>${personal_data.lastname}</td>
                    <td>${personal_data.email}</td>
                    <td>${personal_data.phone}</td>
                </tr>
            </#list>
        </table>
    </body>
</html>