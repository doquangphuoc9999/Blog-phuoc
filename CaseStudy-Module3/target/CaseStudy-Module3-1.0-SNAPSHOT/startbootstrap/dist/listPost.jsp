<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2/23/2021
  Time: 3:43 PM
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
    <title>List Post</title>
    <link href="startbootstrap/dist/css/styles.css" rel="stylesheet" />
    <link
            href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
            rel="stylesheet"
            crossorigin="anonymous"
    />
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js"
            crossorigin="anonymous"
    ></script>
</head>
<body class="sb-nav-fixed">
<%--<%--%>
<%--    response.setHeader("cache-control","no-cache, no-store, must-revalidate");--%>
<%--    response.setHeader("pragma","no-cache");--%>

<%--    if (session.getAttribute("userName"==null))--%>
<%--%>--%>
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <a class="navbar-brand" href="/list">${userName}</a>
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
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/logOut">Logout</a>
            </div>
        </li>
    </ul>
</nav>
<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">List Post</div>
                    <a class="nav-link" href="/list">
                        <div class="sb-nav-link-icon">
                            <i class="fas fa-tachometer-alt"></i>
                        </div>
                        Post list table
                    </a>
                    <div class="sb-sidenav-menu-heading">Manage</div>
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
                        Blog
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
                                    <a class="nav-link" href="/logOut">Login</a>
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
                    <div class="sb-sidenav-menu-heading">Home</div>
                    <a class="nav-link" href="/homeBlog">
                        <div class="sb-nav-link-icon">
                            <i class="fas fa-chart-area"></i>
                        </div>
                        Blog Home
                    </a>
                </div>
            </div>
            <div class="sb-sidenav-footer">
                <div class="small">Logged in as:</div>
                ${user.fullName}
            </div>
        </nav>
    </div>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid">
                <div class="row mt-3 mb-3">
                <h1 class="md-8">List Post</h1>
                <button class="btn btn-primary md-4 ml-auto p-0 mr-3">
                <a href="/addPost" class="text-decoration-none text-white pl-1 pr-1">
                    Add Post
                </a>
                </button>
                </div>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item active">List Post</li>
                </ol>
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table mr-1"></i>
                        DataTable List
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table
                                    class="table table-bordered"
                                    id="dataTable"
                                    width="100%"
                                    cellspacing="0"
                            >
                                <thead>
                                <tr>
                                    <th>id</th>
                                    <th>Title</th>
                                    <th>Images</th>
                                    <th>Category</th>
                                    <th>Short content</th>
                                    <th>Author</th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>id</th>
                                    <th>Title</th>
                                    <th>Images</th>
                                    <th>Category</th>
                                    <th>Short content</th>
                                    <th>Author</th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                </tr>
                                </tfoot>
                                <tbody>
                                    <c:forEach items="${listPost}" var="list">
                                        <tr>
                                            <td>${list.idPost}</td>
                                            <td>${list.title}</td>
                                            <td>
                                                <img style="width:100px ; height: 100px" src="${list.image}" alt="images">
                                            </td>
                                            <td>${list.category.nameCategory}</td>
                                            <td>${list.shortContent}</td>
                                            <td>${list.author.name}</td>
                                            <td><a href="editPost?idPost=${list.idPost}">Edit</a></td>
                                            <td><a href="deletePost?idPost=${list.idPost}" onclick="return confirm('mày muốn xóa hả ')">Delete</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
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
