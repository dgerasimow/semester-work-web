<!DOCTYPE html>
<html lang="en">
<#include "base.ftl">
<#macro title>Posts</#macro>
<body>

<#macro content>
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
</#macro>
</body>
</html>
