<%@page import="com.royal.bean.OrderBean"%>
<%@page import="com.royal.bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<head>
    <!--
        ===
        This comment should NOT be removed.

        Charisma v2.0.0

        Copyright 2012-2014 Muhammad Usman
        Licensed under the Apache License v2.0
        http://www.apache.org/licenses/LICENSE-2.0

        http://usman.it
        http://twitter.com/halalit_usman
        ===
    -->
    <meta charset="utf-8">
    <title>Wonderboon</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

    <!-- The styles -->
    <link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="css/charisma-app.css" rel="stylesheet">
    <link href='bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='css/jquery.noty.css' rel='stylesheet'>
    <link href='css/noty_theme_default.css' rel='stylesheet'>
    <link href='css/elfinder.min.css' rel='stylesheet'>
    <link href='css/elfinder.theme.css' rel='stylesheet'>
    <link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='css/uploadify.css' rel='stylesheet'>
    <link href='css/animate.min.css' rel='stylesheet'>

    <!-- jQuery -->
    <script src="bower_components/jquery/jquery.min.js"></script>

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The fav icon -->
    <link rel="shortcut icon" href="img/giftbox.png">

</head>

<body>
    <!-- topbar starts -->
    <div class="navbar navbar-default" role="navigation">

        <div class="navbar-inner">
            <button type="button" class="navbar-toggle pull-left animated flip">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp"> <img alt="Charisma Logo" src="img/giftbox.png" class="hidden-xs"/>
                <span>Wonderboon</span></a>

             <!-- user dropdown starts -->
            <div class="btn-group pull-right">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> <%=session.getAttribute("store_ownerName") %></span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="form.jsp">Profile</a></li>
                    <li class="divider"></li>
                    <li><a href="login.jsp">Logout</a></li>
                </ul>
            </div>
            <!-- user dropdown ends -->

            <!-- theme selector starts -->
            <div class="btn-group pull-right theme-container animated tada">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-tint"></i><span
                        class="hidden-sm hidden-xs"> Change Theme / Skin</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" id="themes">
                    <li><a data-value="classic" href="#"><i class="whitespace"></i> Classic</a></li>
                    <li><a data-value="cerulean" href="#"><i class="whitespace"></i> Cerulean</a></li>
                    <li><a data-value="cyborg" href="#"><i class="whitespace"></i> Cyborg</a></li>
                    <li><a data-value="simplex" href="#"><i class="whitespace"></i> Simplex</a></li>
                    <li><a data-value="darkly" href="#"><i class="whitespace"></i> Darkly</a></li>
                    <li><a data-value="lumen" href="#"><i class="whitespace"></i> Lumen</a></li>
                    <li><a data-value="slate" href="#"><i class="whitespace"></i> Slate</a></li>
                    <li><a data-value="spacelab" href="#"><i class="whitespace"></i> Spacelab</a></li>
                    <li><a data-value="united" href="#"><i class="whitespace"></i> United</a></li>
                </ul>
            </div>
            <!-- theme selector ends -->

            

        </div>
    </div>
    <!-- topbar ends -->
<div class="ch-container">
    <div class="row">
        
       <!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">Main</li>
                        <li><a class="ajax-link" href="index.jsp"><i class="glyphicon glyphicon-home"></i><span> Dashboard</span></a>
                        </li>
                        <li><a class="ajax-link" href="store_registration.jsp"><i class="glyphicon glyphicon-font"></i><span>Add Store</span></a>
                        </li>
                        <li><a class="ajax-link" href="ListStoreServlet"><i
                                    class="glyphicon glyphicon-list-alt"></i><span>Store List</span></a></li>
                        
                    </ul>
                </div>
            </div>
        </div>
        <!--/span-->
        <!-- left menu ends -->

        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
            <div>
    <ul class="breadcrumb">
        <li>
            <a href="#">Home</a>
        </li>
        <li>
            <a href="#">StoreOwners</a>
        </li>
        <li>
            <a href="#">Store List</a>
        </li>
      
        <li>
            <a href="#">Order List</a>
        </li>
        <li>
            <a href="#">Order Detail</a>
        </li>
    </ul>
</div>



<div class="row">
    <div class="box col-md-12">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-edit"></i> Order Details</h2>

                <div class="box-icon">
                    <a href="#" class="btn btn-setting btn-round btn-default"><i
                            class="glyphicon glyphicon-cog"></i></a>
                    <a href="#" class="btn btn-minimize btn-round btn-default"><i
                            class="glyphicon glyphicon-chevron-up"></i></a>
                    <a href="#" class="btn btn-close btn-round btn-default"><i
                            class="glyphicon glyphicon-remove"></i></a>
                </div>
            </div>
            <div class="box-content">
            
            
       	<%
		OrderBean orderBean = (OrderBean) request.getAttribute("orderBean");
		%>
		
			<div class="box-content">
                <form role="form" action="UpdateStatusServlet">
                   <div class="form-group">
                        <label for="exampleInputEmail1">Product Name</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" readonly="readonly" name="product_Name" value="<%=orderBean.getProduct_Name()%>">
                    </div>
                    
                   <div class="form-group">
                        <label for="exampleInputEmail1">Product Price</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" readonly="readonly" name="product_Price" value="<%=orderBean.getProduct_Price()%>">
                    </div>
                    
                    <div class="form-group">
                        <label for="exampleInputEmail1">Product Quantity</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" readonly="readonly" name="product_Quantity" value="<%=orderBean.getProduct_quantity()%>">
                    </div>
                    
                    <div class="form-group">
                        <label for="exampleInputEmail1">First Name</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" readonly="readonly" name="First_Name" value="<%=orderBean.getFirstname()%>">
                    </div>
                    
                    <div class="form-group">
                        <label for="exampleInputEmail1">Last Name</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" readonly="readonly" name="Last_Name" value="<%=orderBean.getLastname()%>">
                    </div>
                    
                    <div class="form-group">
                        <label for="exampleInputEmail1">Contact Number</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" readonly="readonly" name="contact_no" value="<%=orderBean.getContact()%>">
                    </div>
                    
                    <div class="form-group">
                        <label for="exampleInputEmail1">Email Address</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" readonly="readonly" name="email" value="<%=orderBean.getEmail()%>">
                    </div>
                    
                    <div class="form-group">
                        <label for="exampleInputEmail1">Address Line-1</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" readonly="readonly" name="address_line1" value="<%=orderBean.getAddress1()%>">
                    </div>
                    
                    <div class="form-group">
                        <label for="exampleInputEmail1">Address Line-2</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" readonly="readonly" name="address_line2" value="<%=orderBean.getAddress2()%>">
                    </div> 
                    
                    <div class="form-group">
                        <label for="exampleInputEmail1">State</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" readonly="readonly" name="sname" value="<%=orderBean.getSname()%>">
                    </div> 
                    
                    <div class="form-group">
                        <label for="exampleInputEmail1">City</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" readonly="readonly" name="cname" value="<%=orderBean.getCname()%>">
                    </div> 
                    
                    <div class="form-group">
                        <label for="exampleInputEmail1">Postal Code</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" readonly="readonly" name="postcode" value="<%=orderBean.getPostcode()%>">
                    </div>  
                    
                    <div class="form-group">
                        <label for="exampleInputEmail1">Delivery Date</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" readonly="readonly" name="delivery_date" value="<%=orderBean.getDelivery_date()%>">
                    </div> 
                    
                    <div class="form-group">
                        <label for="exampleInputEmail1">Delivery Time</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" readonly="readonly" name="delivery_time" value="<%=orderBean. getDelivery_time()%>">
                    </div>
                    
                    <div class="form-group">
                        <label for="exampleInputEmail1">Delivery Status</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" readonly="readonly" name="status" value="<%=orderBean.getStatus()%>">
                    </div>     
                 
                 
                </form>

            </div>
		
					
				
            </div>
        </div>
    </div>
    <!--/span-->

</div><!--/row-->

    <!-- content ends -->
    </div><!--/#content.col-md-0-->
</div><!--/fluid-row-->

    <!-- Ad, you can remove it -->
    <div class="row">
        <div class="col-md-9 col-lg-9 col-xs-9 hidden-xs">
            <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
            <!-- Charisma Demo 2 -->
            <ins class="adsbygoogle"
                 style="display:inline-block;width:728px;height:90px"
                 data-ad-client="ca-pub-5108790028230107"
                 data-ad-slot="3193373905"></ins>
            <script>
                (adsbygoogle = window.adsbygoogle || []).push({});
            </script>
        </div>
        
    </div>
    <!-- Ad ends -->

    <hr>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">

        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h3>Settings</h3>
                </div>
                <div class="modal-body">
                    <p>Here settings can be configured...</p>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
                    <a href="#" class="btn btn-primary" data-dismiss="modal">Save changes</a>
                </div>
            </div>
        </div>
    </div>

    <footer class="row">
        <p class="col-md-9 col-sm-9 col-xs-12 copyright">&copy; <a href="#">Dhaval Chodvadiya</a> 2019 - 2020</p>

         <p class="col-md-3 col-sm-3 col-xs-12 powered-by">Powered by: <a
                href="index.jsp">Wonderboon</a></p>
    </footer>
    
</div><!--/.fluid-container-->

<!-- external javascript -->

<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='bower_components/moment/min/moment.min.js'></script>
<script src='bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='js/jquery.dataTables.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="js/charisma.js"></script>


</body>
</html>