<!DOCTYPE html>
<html lang="en">
<#include "base.ftl">
<#macro title>My profile</#macro>
<body>
<#macro content>
<div class="container">

    <!-- Timeline
    ================================================= -->
    <#if user??>
    <div class="timeline">
        <div class="timeline-cover">

            <!--Timeline Menu for Large Screens-->
            <div class="timeline-nav-bar hidden-sm hidden-xs">
                <div class="row">
                    <div class="col-md-3">
                        <div class="profile-info">
                            <img src="http://placehold.it/300x300" alt="" class="img-responsive profile-photo" />
                            <h3>${user.firstName} ${user.secondName}</h3>
                            <p class="text-muted">Creative Director</p>
                        </div>
                    </div>
                    <div class="col-md-9">
                        <ul class="follow-me list-inline">
                            <li>1,299 people following her</li>
                            <li><button class="btn-primary">Add Friend</button></li>
                        </ul>
                    </div>
                </div>
            </div><!--Timeline Menu for Large Screens End-->


        </div>
        <div id="page-contents">
            <div class="row">
                <div class="col-md-3"></div>
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
                    <#if posts??>
                        <#list posts as p>
                    <div class="post-content">

                        <div class="post-date hidden-xs hidden-sm">
                            <h5>${user.firstName}</h5>
                            <p class="text-grey">${p.creationTime}</p>
                        </div>

                        <img src="http://placehold.it/1920x1280" alt="post-image" class="img-responsive post-image" />
                        <div class="post-container">
                            <img src="http://placehold.it/300x300" alt="user" class="profile-photo-md pull-left" />
                            <div class="post-detail">
                                <div class="user-info">
                                    <h5><a href="timeline.html" class="profile-link">${user.firstName} ${user.secondName}</a> <span class="following">following</span></h5>
                                    <p class="text-muted">${p.creationTime}</p>
                                </div>
                                <div class="reaction">
                                    <a class="btn text-green"><i class="icon ion-thumbsup"></i> 13</a>
                                    <a class="btn text-red"><i class="fa fa-thumbs-down"></i> 0</a>
                                </div>
                                <div class="line-divider"></div>
                                <div class="post-text">
                                    <p>${p.postText}<i class="em em-anguished"></i> <i class="em em-anguished"></i> <i class="em em-anguished"></i></p>
                                </div>
                                <div class="line-divider"></div>
                            </div>
                        </div>
                    </div>

                        </#list>
                    </#if>

                </div>
            </div>
        </div>
        </#if>

</#macro>
</body>
</html>
