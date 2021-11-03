<!DOCTYPE html>
<html lang="en">
<#include "base.ftl">
<#macro title>Посты</#macro>
<body>

<#macro content>
<div id="page-contents">
    <div class="container">
        <div class="row">
            <#if user??>
            <!-- Newsfeed Common Side Bar Left
            ================================================= -->
            <div class="col-md-3 static">
                <div class="profile-card">
                    <img src="http://placehold.it/300x300" alt="user" class="profile-photo" />
                    <h5><a href="/profile?id=${user.id}" class="text-white">${user.firstName} ${user.secondName}</a></h5>
                    <a href="/subs" class="text-white"><i class="ion ion-android-person-add"></i> подписчики</a>
                </div><!--profile card ends-->
                <ul class="nav-news-feed">
                    <li><i class="icon ion-ios-paper"></i><div><a href="/profile?id=${user.id}">Мой профиль</a></div></li>
                </ul><!--news-feed links ends-->
            </div>
            </#if>
            <div class="col-md-7">
                <!-- Post Content
                ================================================= -->
                <#if posts??>
                <#list posts as p, c>
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

                        <#list c as comment>
                            <div class="post-comment">
                                <img src="http://placehold.it/300x300" alt="" class="profile-photo-sm" />
                                <p><a href="timeline.html" class="profile-link">${comment.userFirstName} </a>${comment.comment_text}</p>
                            </div>
                            </#list>
                        <div id="last-divider"></div>
                        <form method="POST" id="add-new-comment">
                            <div class="post-comment">
                                <img src="http://placehold.it/300x300" alt="" class="profile-photo-sm" />
                                <input type="hidden" id="post-id" value="${p.id}">
                                <input type="hidden" id="user-id" value="${user.id}">
                                <input type="text" id="comment-text" name="comment-text" class="form-control" placeholder="Post a comment">
                                <input type="submit" class="btn btn-primary pull-right" value="Написать">
                            </div>
                        </form>
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
