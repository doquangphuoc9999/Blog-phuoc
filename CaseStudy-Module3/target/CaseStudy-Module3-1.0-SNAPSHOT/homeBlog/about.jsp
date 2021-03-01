<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2/28/2021
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>About</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300, 400,700" rel="stylesheet">

    <link rel="stylesheet" href="homeBlog/css/bootstrap.css">
    <link rel="stylesheet" href="homeBlog/css/animate.css">
    <link rel="stylesheet" href="homeBlog/css/owl.carousel.min.css">

    <link rel="stylesheet" href="homeBlog/fonts/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="homeBlog/fonts/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="homeBlog/fonts/flaticon/font/flaticon.css">

    <!-- Theme Style -->
    <link rel="stylesheet" href="homeBlog/css/style.css">
</head>
<body>



<header role="banner">
    <div class="top-bar">
        <div class="container">
            <div class="row">
                <div class="col-9 social">
                    <a href="#"><span class="fa fa-twitter"></span></a>
                    <a href="#"><span class="fa fa-facebook"></span></a>
                    <a href="#"><span class="fa fa-instagram"></span></a>
                    <a href="#"><span class="fa fa-youtube-play"></span></a>
                    <a href="#"><span class="fa fa-vimeo"></span></a>
                    <a href="#"><span class="fa fa-snapchat"></span></a>
                </div>
                <div class="col-3 search-top">
                    <form action="/searchTitle" method="get" class="search-top-form">
                        <span class="icon fa fa-search"></span>
                        <input type="text" name="title" placeholder="Type keyword to search...">
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="container logo-wrap">
        <div class="row pt-5">
            <div class="col-12 text-center">
                <a class="absolute-toggle d-block d-md-none" data-toggle="collapse" href="#navbarMenu" role="button" aria-expanded="false" aria-controls="navbarMenu"><span class="burger-lines"></span></a>
                <h1 class="site-logo"><a href="/homeBlog">Ông Phước Vlog</a></h1>
            </div>
        </div>
    </div>

    <nav class="navbar navbar-expand-md  navbar-light bg-light">
        <div class="container">


            <div class="collapse navbar-collapse" id="navbarMenu">
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/homeBlog">Home</a>
                    </li>
<%--                    <li class="nav-item dropdown">--%>
<%--                        <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Travel</a>--%>
<%--                        <div class="dropdown-menu" aria-labelledby="dropdown04">--%>
<%--                            <a class="dropdown-item" href="#">Asia</a>--%>
<%--                            <a class="dropdown-item" href="#">Europe</a>--%>
<%--                            <a class="dropdown-item" href="#">Dubai</a>--%>
<%--                            <a class="dropdown-item" href="#">Africa</a>--%>
<%--                            <a class="dropdown-item" href="#">South America</a>--%>
<%--                        </div>--%>

<%--                    </li>--%>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown05" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Categories</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown05">
                            <c:forEach items="${listCategory}" var="list">
                                <a class="dropdown-item" href="/category?id=${list.id}">${list.nameCategory}</a>
                            </c:forEach>
                        </div>

                    </li>

                    <li class="nav-item">
                        <a class="nav-link active" href="/aboutBlog">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/contact">Contact</a>
                    </li>
                </ul>

            </div>
        </div>
    </nav>
</header>
<!-- END header -->


<section class="site-section">
    <div class="container">

        <div class="row blog-entries">
            <div class="col-md-12 col-lg-8 main-content">

                <div class="row">
                    <div class="col-md-12">
                        <h2 class="mb-4">Hi There! I'm Quang Phuoc Do</h2>
                        <p class="mb-5"><img src="homeBlog/images/avataAbout.jpg" width="50%" alt="Image placeholder" class="img-fluid"></p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsum minima eveniet recusandae suscipit eum laboriosam fugit amet deleniti iste et. Ad dolores, necessitatibus non saepe tenetur impedit commodi quibusdam natus repellat, exercitationem accusantium perferendis officiis. Laboriosam impedit quia minus pariatur!</p>
                        <p>Dignissimos iste consectetur, nemo magnam nulla suscipit eius quibusdam, quo aperiam quia quae est explicabo nostrum ab aliquid vitae obcaecati tenetur beatae animi fugiat officia id ipsam sint? Obcaecati ea nisi fugit assumenda error totam molestiae saepe fugiat officiis quam?</p>
                        <p>Culpa porro quod doloribus dolore sint. Distinctio facilis ullam voluptas nemo voluptatum saepe repudiandae adipisci officiis, explicabo eaque itaque sed necessitatibus, fuga, ea eius et aliquam dignissimos repellendus impedit pariatur voluptates. Dicta perferendis assumenda, nihil placeat, illum quibusdam. Vel, incidunt?</p>
                        <p>Dolorum blanditiis illum quo quaerat, possimus praesentium perferendis! Quod autem optio nobis, placeat officiis dolorem praesentium odit. Vel, cum, a. Adipisci eligendi eaque laudantium dicta tenetur quod, pariatur sunt sed natus officia fuga accusamus reprehenderit ratione, provident possimus ut voluptatum.</p>
                    </div>
                </div>

                <div class="row mb-5 mt-5">
                    <div class="col-md-12 mb-5">
                        <h2>My Latest Posts</h2>
                    </div>
                    <div class="col-md-12">
                        <c:forEach items="${listAll}" var="list">
                            <div class="post-entry-horzontal">
                                <a href="/blogSingle?id=${list.idPost}">
                                    <div class="image" style="background-image: url(${list.image});"></div>
                                    <span class="text">
                      <div class="post-meta">
                        <span class="category">${list.category.nameCategory}</span>
                        <span class="mr-2">${list.publisht}</span> &bullet;
                        <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                      </div>
                      <h2>${list.shortContent}</h2>
                    </span>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 text-center">
                        <nav aria-label="Page navigation" class="text-center">
                            <ul class="pagination">
                                <li class="page-item  active"><a class="page-link" href="#">Prev</a></li>
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item"><a class="page-link" href="#">Next</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>



            </div>

            <!-- END main-content -->

            <div class="col-md-12 col-lg-4 sidebar">
                <div class="sidebar-box search-form-wrap">
                    <form action="/searchTitle" method="get" class="search-form">
                        <div class="form-group">
                            <span class="icon fa fa-search"></span>
                            <input type="text" class="form-control" name="title" placeholder="Type a keyword and hit enter">
                        </div>
                    </form>
                </div>
                <!-- END sidebar-box -->
                <div class="sidebar-box">
                    <div class="bio text-center">
                        <img src="homeBlog/images/avataAbout.jpg" alt="Image Placeholder" class="img-fluid">
                        <div class="bio-body">
                            <h2>Quang Phuoc</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Exercitationem facilis sunt repellendus excepturi beatae porro debitis voluptate nulla quo veniam fuga sit molestias minus.</p>
                            <p><a href="#" class="btn btn-primary btn-sm">Read my bio</a></p>
                            <p class="social">
                                <a href="#" class="p-2"><span class="fa fa-facebook"></span></a>
                                <a href="#" class="p-2"><span class="fa fa-twitter"></span></a>
                                <a href="#" class="p-2"><span class="fa fa-instagram"></span></a>
                                <a href="#" class="p-2"><span class="fa fa-youtube-play"></span></a>
                            </p>
                        </div>
                    </div>
                </div>
                <!-- END sidebar-box -->
                <div class="sidebar-box">
                    <h3 class="heading">Popular Posts</h3>
                    <div class="post-entry-sidebar">
                        <ul>
                            <c:forEach var="list" items="${randomList}">
                                <li>
                                    <a href="/blogSingle?id=${list.idPost}">
                                        <img src="${list.image}" alt="Image placeholder" class="mr-4">
                                        <div class="text">
                                            <h4>${list.title}</h4>
                                            <div class="post-meta">
                                                <span class="mr-2">${list.publisht}</span> &bullet;
                                                <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <!-- END sidebar-box -->

                <div class="sidebar-box">
                    <h3 class="heading">Categories</h3>
                    <ul class="categories">
                        <li>
                            <a href="#">Courses <span>(12)</span></a>
                        </li>
                        <li><a href="#">News <span>(22)</span></a></li>
                        <li><a href="#">Design <span>(37)</span></a></li>
                        <li><a href="#">HTML <span>(42)</span></a></li>
                        <li><a href="#">Web Development <span>(14)</span></a></li>
                    </ul>
                </div>
                <!-- END sidebar-box -->

                <div class="sidebar-box">
                    <h3 class="heading">Tags</h3>
                    <ul class="tags">
                        <li><a href="#">Travel</a></li>
                        <li><a href="#">Adventure</a></li>
                        <li><a href="#">Food</a></li>
                        <li><a href="#">Lifestyle</a></li>
                        <li><a href="#">Business</a></li>
                        <li><a href="#">Freelancing</a></li>
                        <li><a href="#">Travel</a></li>
                        <li><a href="#">Adventure</a></li>
                        <li><a href="#">Food</a></li>
                        <li><a href="#">Lifestyle</a></li>
                        <li><a href="#">Business</a></li>
                        <li><a href="#">Freelancing</a></li>
                    </ul>
                </div>
            </div>
            <!-- END sidebar -->

        </div>
    </div>
</section>

<footer class="site-footer">
    <div class="container">
        <div class="row mb-5">
            <div class="col-md-4">
                <h3>Paragraph</h3>
                <p>
                    <img src="homeBlog/images/avataAbout.jpg" alt="Image placeholder" class="img-fluid">
                </p>

                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nisi, accusantium optio unde perferendis eum illum voluptatibus dolore tempora, consequatur minus asperiores temporibus reprehenderit.</p>
            </div>
            <div class="col-md-6 ml-auto">
                <div class="row">
                    <div class="col-md-7">
                        <h3>Latest Post</h3>
                        <div class="post-entry-sidebar">
                            <ul>
                                <c:forEach var="newList" items="${newPost}">
                                    <li>
                                        <a href="/blogSingle?id=${newList.idPost}">
                                            <img src="${newList.image}" alt="Image placeholder" class="mr-4">
                                            <div class="text">
                                                <h4>${newList.title}</h4>
                                                <div class="post-meta">
                                                    <span class="mr-2">${newList.publisht}</span> &bullet;
                                                    <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-1"></div>

                    <div class="col-md-4">

                        <div class="mb-5">
                            <h3>Quick Links</h3>
                            <ul class="list-unstyled">
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Travel</a></li>
                                <li><a href="#">Adventure</a></li>
                                <li><a href="#">Courses</a></li>
                                <li><a href="#">Categories</a></li>
                            </ul>
                        </div>

                        <div class="mb-5">
                            <h3>Social</h3>
                            <ul class="list-unstyled footer-social">
                                <li><a href="#"><span class="fa fa-twitter"></span> Twitter</a></li>
                                <li><a href="#"><span class="fa fa-facebook"></span> Facebook</a></li>
                                <li><a href="#"><span class="fa fa-instagram"></span> Instagram</a></li>
                                <li><a href="#"><span class="fa fa-vimeo"></span> Vimeo</a></li>
                                <li><a href="#"><span class="fa fa-youtube-play"></span> Youtube</a></li>
                                <li><a href="#"><span class="fa fa-snapchat"></span> Snapshot</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </div>
        </div>
    </div>
</footer>
<!-- END footer -->

<!-- loader -->
<div id="loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#f4b214"/></svg></div>

<script src="homeBlog/js/jquery-3.2.1.min.js"></script>
<script src="homeBlog/js/jquery-migrate-3.0.0.js"></script>
<script src="homeBlog/js/popper.min.js"></script>
<script src="homeBlog/js/bootstrap.min.js"></script>
<script src="homeBlog/js/owl.carousel.min.js"></script>
<script src="homeBlog/js/jquery.waypoints.min.js"></script>
<script src="homeBlog/js/jquery.stellar.min.js"></script>


<script src="homeBlog/js/main.js"></script>
</body>
</html>
