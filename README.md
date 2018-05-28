<h1> monitoringAppV1</h1>
<h4>coding test paysafe group</h4>

<b>Technologies used</b>: spring Boot using Gradle build tool to build the Rest Endpoints to complete the Task

<h4>List of Rest Uri(s):</h4>
 <table> 
 <tr> <th>URI</th>          <th> Method Type </th>                    <th> Description </th> </tr>
 
<tr><td>/monitor/start</td>      <td>POST</td>                        <td>start the server monitoring by calling the api using "Server" field 
                                                                      and schedule the occurrence of api call based on 
                                                                      "interval" field from body of post Request.</td> </tr>
                                                                      </table>

<h6>requires <b>Body</b> with <b>interval(Seconds)</b>  and <b>server(name)</b></h6>
Example Request: <br>
POST /monitor/start HTTP/1.1 <br>
Host: localhost:8083        <br>
Content-Type: application/json  <br>
Cache-Control: no-cache<br>
{"interval":5, "server":"accountmanagement" }  <br><br>          

..................................................................................................................................................................................................... 
<table> 
 <tr> <th>URI</th>         <th> Method Type </th>                    <th>Description </th> </tr>
 <tr><td> /monitor/stop</td>               <td>PUT</td>                         <td>stops the server monitoring</td></tr><table> 

Example request: <br> PUT /monitor/stop HTTP/1.1<br>
                  Host: localhost:8083<br>
                  Cache-Control: no-cache<br><br>


....................................................................................................................................................................................................
<table> 
 <tr> <th>URI</th>                     <th> Method Type </th>                    <th>Description </th> </tr>
<tr><td>/monitor/overview</td>              <td>GET</td>                 <td>It provides overview of monitored server's availability</td></tr></table>

Example request:<br>GET /monitor/overview HTTP/1.1<br>
                    Host: localhost:8083<br>
                    Cache-Control: no-cache <br>
}
