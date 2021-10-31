<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="This is social network html5 template available in themeforest......" />
    <meta name="keywords" content="Social Network, Social Media, Make Friends, Newsfeed, Profile Page" />
    <meta name="robots" content="index, follow" />
    <title>News Feed | Check what your friends are doing</title>

    <!-- Stylesheets -->
    ================================================= --
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css" />
    <link rel="stylesheet" href="/css/ionicons.min.css" />
    <link rel="stylesheet" href="/css/font-awesome.min.css" />
    <link href="/css/emoji.css" rel="stylesheet">

    <!--Google Font-->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i,700,700i" rel="stylesheet">

    <!--Favicon-->
    <link rel="shortcut icon" type="image/png" href="images/fav.png"/>
</head>
<body>

<!-- Header
================================================= -->
<header id="header">
    <nav class="navbar navbar-default navbar-fixed-top menu">
        <div class="container">

            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index-register.html"><img src="images/logo.png" alt="logo" /></a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right main-menu">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Home <span><img src="images/down-arrow.png" alt="" /></span></a>
                        <ul class="dropdown-menu newsfeed-home">
                            <li><a href="index.html">Landing Page 1</a></li>
                            <li><a href="index-register.html">Landing Page 2</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Newsfeed <span><img src="images/down-arrow.png" alt="" /></span></a>
                        <ul class="dropdown-menu newsfeed-home">
                            <li><a href="newsfeed.html">Newsfeed</a></li>
                            <li><a href="newsfeed-people-nearby.html">Poeple Nearly</a></li>
                            <li><a href="newsfeed-friends.html">My friends</a></li>
                            <li><a href="newsfeed-messages.html">Chatroom</a></li>
                            <li><a href="newsfeed-images.html">Images</a></li>
                            <li><a href="newsfeed-videos.html">Videos</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Timeline <span><img src="images/down-arrow.png" alt="" /></span></a>
                        <ul class="dropdown-menu login">
                            <li><a href="timeline.html">Timeline</a></li>
                            <li><a href="timeline-about.html">Timeline About</a></li>
                            <li><a href="timeline-album.html">Timeline Album</a></li>
                            <li><a href="timeline-friends.html">Timeline Friends</a></li>
                            <li><a href="edit-profile-basic.html">Edit: Basic Info</a></li>
                            <li><a href="edit-profile-work-edu.html">Edit: Work</a></li>
                            <li><a href="edit-profile-interests.html">Edit: Interests</a></li>
                            <li><a href="edit-profile-settings.html">Account Settings</a></li>
                            <li><a href="edit-profile-password.html">Change Password</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle pages" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">All Pages <span><img src="images/down-arrow.png" alt="" /></span></a>
                        <ul class="dropdown-menu page-list">
                            <li><a href="index.html">Landing Page 1</a></li>
                            <li><a href="index-register.html">Landing Page 2</a></li>
                            <li><a href="newsfeed.html">Newsfeed</a></li>
                            <li><a href="newsfeed-people-nearby.html">Poeple Nearly</a></li>
                            <li><a href="newsfeed-friends.html">My friends</a></li>
                            <li><a href="newsfeed-messages.html">Chatroom</a></li>
                            <li><a href="newsfeed-images.html">Images</a></li>
                            <li><a href="newsfeed-videos.html">Videos</a></li>
                            <li><a href="timeline.html">Timeline</a></li>
                            <li><a href="timeline-about.html">Timeline About</a></li>
                            <li><a href="timeline-album.html">Timeline Album</a></li>
                            <li><a href="timeline-friends.html">Timeline Friends</a></li>
                            <li><a href="edit-profile-basic.html">Edit Profile</a></li>
                            <li><a href="contact.html">Contact Us</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="contact.html">Contact</a></li>
                </ul>
                <form class="navbar-form navbar-right hidden-sm">
                    <div class="form-group">
                        <i class="icon ion-android-search"></i>
                        <input type="text" class="form-control" placeholder="Search friends, photos, videos">
                    </div>
                </form>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container -->
    </nav>
</header>
<!--Header End-->

<div id="page-contents">
    <div class="container">
        <div class="row">

            <!-- Newsfeed Common Side Bar Left
            ================================================= -->
            <div class="col-md-3 static">
                <div class="profile-card">
                    <img src="http://placehold.it/300x300" alt="user" class="profile-photo" />
                    <h5><a href="timeline.html" class="text-white">Sarah Cruiz</a></h5>
                    <a href="#" class="text-white"><i class="ion ion-android-person-add"></i> 1,299 followers</a>
                </div><!--profile card ends-->
                <ul class="nav-news-feed">
                    <li><i class="icon ion-ios-paper"></i><div><a href="newsfeed.html">My Newsfeed</a></div></li>
                </ul><!--news-feed links ends-->
            </div>

            <div class="col-md-7">

                <!-- Post Create Box
                ================================================= -->
                <div class="create-post">
                    <div class="row">
                        <div class="col-md-7 col-sm-7">
                            <div class="form-group">
                                <img src="http://placehold.it/300x300" alt="" class="profile-photo-md" />
                                <textarea name="texts" id="exampleTextarea" cols="30" rows="1" class="form-control" placeholder="Write what you wish"></textarea>
                            </div>
                        </div>
                        <div class="col-md-5 col-sm-5">
                            <div class="tools">
                                <button class="btn btn-primary pull-right">Publish</button>
                            </div>
                        </div>
                    </div>
                </div><!-- Post Create Box End-->

                <!-- Post Content
                ================================================= -->
                <#if posts??>
                <#list posts as p>
                <div class="post-content">
                    <img src="http://placehold.it/1920x1280" alt="post-image" class="img-responsive post-image" />
                    <div class="post-container">
                        <img src="http://placehold.it/300x300" alt="user" class="profile-photo-md pull-left" />

                                    <div class="post-detail">
                                    <div class="user-info">
                                    <h5>${p.creatorName}</h5>
                                    <p class="text-muted">Опубликовал в ${p.creationTime}</p>
                                </div>
                                    <div class="line-divider"></div>
                                    <div class="post-text">
                                        <p>${p.postText}</p>
                                    </div>
                                    <div class="line-divider"></div>
                                    </div>

                            <div class="post-comment">
                                <img src="http://placehold.it/300x300" alt="" class="profile-photo-sm" />
                                <p><a href="timeline.html" class="profile-link">Diana </a><i class="em em-laughing"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud </p>
                            </div>
                            <div class="post-comment">
                                <img src="http://placehold.it/300x300" alt="" class="profile-photo-sm" />
                                <p><a href="timeline.html" class="profile-link">John</a> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud </p>
                            </div>
                            <div class="post-comment">
                                <img src="http://placehold.it/300x300" alt="" class="profile-photo-sm" />
                                <input type="text" class="form-control" placeholder="Post a comment">
                            </div>
                        </div>
                    </div>
            </#list>
            </#if>
            </div>
        </div>
    </div>
</div>

<!-- Footer
================================================= -->
<footer id="footer">
    <div class="container">
        <div class="row">
            <div class="footer-wrapper">
                <div class="copyright">
                    <p>Thunder Team © 2016. All rights reserved</p>
                 </div>
            </div>
        </div>
    </div>
</footer>

<!--preloader-->
<div id="spinner-wrapper">
    <div class="spinner"></div>
</div>

<!-- Scripts
================================================= -->
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCTMXfmDn0VlqWIyoOxK8997L-amWbUPiQ&callback=initMap"></script>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.sticky-kit.min.js"></script>
<script src="js/jquery.scrollbar.min.js"></script>
<script src="js/script.js"></script>
</body>
</html>
