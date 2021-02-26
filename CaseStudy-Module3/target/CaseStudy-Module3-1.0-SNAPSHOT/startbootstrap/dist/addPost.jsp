<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2/23/2021
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Add post</title>
    <link href="startbootstrap/dist/css/styles.css" rel="stylesheet" />
    <link
            href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
            rel="stylesheet"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link href="startbootstrap/dist/css/add.css" type="text/css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js"
            crossorigin="anonymous"
    ></script>
</head>
<body class="sb-nav-fixed">
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <a class="navbar-brand" href="index.html">Article management</a>
    <button
            class="btn btn-link btn-sm order-1 order-lg-0"
            id="sidebarToggle"
            href="#"
    >
        <i class="fas fa-bars"></i>
    </button>
    <!-- Navbar Search-->
    <form
            class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0"
    >
        <div class="input-group">
            <input
                    class="form-control"
                    type="text"
                    placeholder="Search for..."
                    aria-label="Search"
                    aria-describedby="basic-addon2"
            />
            <div class="input-group-append">
                <button class="btn btn-primary" type="button">
                    <i class="fas fa-search"></i>
                </button>
            </div>
        </div>
    </form>
    <!-- Navbar-->
    <ul class="navbar-nav ml-auto ml-md-0">
        <li class="nav-item dropdown">
            <a
                    class="nav-link dropdown-toggle"
                    id="userDropdown"
                    href="#"
                    role="button"
                    data-toggle="dropdown"
                    aria-haspopup="true"
                    aria-expanded="false"
            ><i class="fas fa-user fa-fw"></i
            ></a>
            <div
                    class="dropdown-menu dropdown-menu-right"
                    aria-labelledby="userDropdown"
            >
                <a class="dropdown-item" href="#">Settings</a>
                <a class="dropdown-item" href="#">Activity Log</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="login.html">Logout</a>
            </div>
        </li>
    </ul>
</nav>
<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">Menu</div>
                    <a class="nav-link" href="/list">
                        <div class="sb-nav-link-icon">
                            <i class="fas fa-tachometer-alt"></i>
                        </div>
                        Post list table
                    </a>
                    <div class="sb-sidenav-menu-heading">MANAGE</div>
                    <a
                            class="nav-link collapsed"
                            href="#"
                            data-toggle="collapse"
                            data-target="#collapseLayouts"
                            aria-expanded="false"
                            aria-controls="collapseLayouts"
                    >
                        <div class="sb-nav-link-icon">
                            <i class="fas fa-columns"></i>
                        </div>
                        Category, Author
                        <div class="sb-sidenav-collapse-arrow">
                            <i class="fas fa-angle-down"></i>
                        </div>
                    </a>
                    <div
                            class="collapse"
                            id="collapseLayouts"
                            aria-labelledby="headingOne"
                            data-parent="#sidenavAccordion"
                    >
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="/manageCategory"
                            >Manage Category</a
                            >
                            <a class="nav-link" href="/manageAuthor"
                            >Manage Author</a
                            >
                        </nav>
                    </div>
                    <a
                            class="nav-link collapsed"
                            href="#"
                            data-toggle="collapse"
                            data-target="#collapsePages"
                            aria-expanded="false"
                            aria-controls="collapsePages"
                    >
                        <div class="sb-nav-link-icon">
                            <i class="fas fa-book-open"></i>
                        </div>
                        Pages
                        <div class="sb-sidenav-collapse-arrow">
                            <i class="fas fa-angle-down"></i>
                        </div>
                    </a>
                    <div
                            class="collapse"
                            id="collapsePages"
                            aria-labelledby="headingTwo"
                            data-parent="#sidenavAccordion"
                    >
                        <nav
                                class="sb-sidenav-menu-nested nav accordion"
                                id="sidenavAccordionPages"
                        >
                            <a
                                    class="nav-link collapsed"
                                    href="#"
                                    data-toggle="collapse"
                                    data-target="#pagesCollapseAuth"
                                    aria-expanded="false"
                                    aria-controls="pagesCollapseAuth"
                            >
                                Authentication
                                <div class="sb-sidenav-collapse-arrow">
                                    <i class="fas fa-angle-down"></i>
                                </div>
                            </a>
                            <div
                                    class="collapse"
                                    id="pagesCollapseAuth"
                                    aria-labelledby="headingOne"
                                    data-parent="#sidenavAccordionPages"
                            >
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="login.html">Login</a>
                                    <a class="nav-link" href="register.html">Register</a>
                                    <a class="nav-link" href="password.html"
                                    >Forgot Password</a
                                    >
                                </nav>
                            </div>
                            <a
                                    class="nav-link collapsed"
                                    href="#"
                                    data-toggle="collapse"
                                    data-target="#pagesCollapseError"
                                    aria-expanded="false"
                                    aria-controls="pagesCollapseError"
                            >
                                Error
                                <div class="sb-sidenav-collapse-arrow">
                                    <i class="fas fa-angle-down"></i>
                                </div>
                            </a>
                            <div
                                    class="collapse"
                                    id="pagesCollapseError"
                                    aria-labelledby="headingOne"
                                    data-parent="#sidenavAccordionPages"
                            >
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="401.html">401 Page</a>
                                    <a class="nav-link" href="404.html">404 Page</a>
                                    <a class="nav-link" href="500.html">500 Page</a>
                                </nav>
                            </div>
                        </nav>
                    </div>
                    <div class="sb-sidenav-menu-heading">Addons</div>
                    <a class="nav-link" href="charts.html">
                        <div class="sb-nav-link-icon">
                            <i class="fas fa-chart-area"></i>
                        </div>
                        Charts
                    </a>
                    <a class="nav-link" href="tables.html">
                        <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                        Tables
                    </a>
                </div>
            </div>
            <div class="sb-sidenav-footer">
                <div class="small">Logged in as:</div>
                Start Bootstrap
            </div>
        </nav>
    </div>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid">
<%--                <div class="row mt-3 mb-3">--%>
<%--                    <h1 class="md-8">List Post</h1>--%>
<%--                    <button class="btn btn-primary md-4 ml-auto p-0 mr-3">--%>
<%--                        <a href="/addPost" class="text-decoration-none text-white pl-1 pr-1">--%>
<%--                            Add Post--%>
<%--                        </a>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--                <ol class="breadcrumb mb-4">--%>
<%--                    <li class="breadcrumb-item active">List Post</li>--%>
<%--                </ol>--%>
                <div class="page-add" style="margin: 30px;">
                    <div class="content" style="border: 1px solid; padding: 50px">
                        <h2 style="text-align: center; margin-bottom: 23px">Add post</h2>
                        <h2 style="text-align: center; margin-bottom: 23px">${mess}</h2>
                        <form action="/addPost" method="post">
                            <div class="title">
                                <label><b>Title</b></label>
                                <input  type="text" name="title" placeholder="Enter title....">
                            </div>
                            <div class="shortContent">
                                <label><b>Short Content</b></label>
                                <input type="text" name="shortContent" placeholder="Enter short content...">
                            </div>
                            <div class="image ">
                                <label><b>Link images</b></label>
                                <input  type="text" name="image" placeholder="Enter link images">
                            </div>
                            <div class="full-content">
                                <label><b>Full Content</b></label>
                                <textarea id="summernote" name="fullContent"></textarea>
                            </div>
                            <div class="list">
                                <div class="category">
                                    <label><b>category</b></label>
                                    <select name="category">
                                        <option>Option</option>
                                        <c:forEach items="${listCategory}" var="listCategorys">
                                            <option value="${listCategorys.id}">${listCategorys.nameCategory}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="author">
                                    <label><b>Author</b></label>
                                    <select name="author">
                                        <option>Option</option>
                                        <c:forEach items="${listAuthor}" var="list">
                                            <option value="${list.id}">${list.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="back">
                                <div class="option">
                                    <input class="submit" type="submit">
                                    <input type="reset">
                                </div>
                                <div class="home">
                                    <h4><button><a href="/list">Comeback post list</a></button></h4>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </main>
        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid">
                <div
                        class="d-flex align-items-center justify-content-between small"
                >
                    <div class="text-muted">Copyright &copy; Your Website 2020</div>
                    <div>
                        <a href="#">Privacy Policy</a>
                        &middot;
                        <a href="#">Terms &amp; Conditions</a>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>
<script>
    $('#summernote').summernote({
        placeholder: 'Enter full content...',
        tabsize: 2,
        height: 300,
        name: "fullContent"
    });
</script>
<script
        src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        crossorigin="anonymous"
></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"
></script>
<script src="startbootstrap/dist/js/scripts.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
        crossorigin="anonymous"
></script>
<script src="startbootstrap/dist/assets/demo/chart-area-demo.js"></script>
<script src="startbootstrap/dist/assets/demo/chart-bar-demo.js"></script>
<script
        src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
        crossorigin="anonymous"
></script>
<script
        src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
        crossorigin="anonymous"
></script>
<script src="startbootstrap/dist/assets/demo/datatables-demo.js"></script>
</body>
</html>
