<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <style type="text/css">
        body {
            background-image:
                url('http://cdn.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
        }
    </style>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="manifest" href="/manifest.json">
        <script src="https://cdn.onesignal.com/sdks/OneSignalSDK.js" async></script>
        <script>
            var OneSignal = window.OneSignal || [];
            OneSignal.push(["init", {
                    appId: "<%=System.getenv("ONESIGNAL_ID")%>",
                    autoRegister: false,
                    notifyButton: {
                        enable: true /* Set to false to hide */
                    }
                }]);
        </script>
        <title>AppuMart:</title>
    </head>
    <body>
        <div align="center" style="margin-top: 50px;">
            <form action="CrunchifyServlet">
                Clave:  <input type="text" name="clave"> <br>
                <input type="submit" value="mostrar"><br>
                <h6>La noificación solo se muestra si la clave es 1100</h6>
                
            </form>

        </div>


    </body>
</html>
