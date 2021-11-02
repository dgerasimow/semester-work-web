<!DOCTYPE html>
<html lang="en">
<#include "base.ftl">
<#--<head>-->
<#--    <script>-->
<#--        $("create-post-form").submit(function (e) {-->
<#--            e.preventDefault();-->

<#--            var form = $(this);-->
<#--            var url = form.attr('action')-->

<#--            $.ajax({-->
<#--                type: "POST",-->
<#--                url: url,-->
<#--                data: form.serialize(),-->
<#--                success: function(data)-->
<#--                {-->
<#--                    alert(data);-->
<#--                }-->
<#--            });-->
<#--        });-->
<#--    </script>-->
<#--</head>-->
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
                            <p class="text-muted">Хуйлан че</p>
                        </div>
                    </div>
                    <div class="col-md-9">
                        <ul class="list-inline profile-menu">
                            <li><p>не подписан</p>
                        </ul>
                        <ul class="follow-me list-inline">
                            <li>1299 подписчиков</li>
                            <li><form action="/subscribe" method="POST">
                                    <input type="hidden" name="user" value=${user.id}>
                                    <input type="hidden" name="currentUserId" value=${currentUserId}>
                                    <input type="submit" class="btn-primary" value="Добавить">
                                </form></li>
                        </ul>
                    </div>
                </div>
            </div><!--Timeline Menu for Large Screens End-->


        </div>
        <div id="page-contents">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-7">

                    <#if userPosts??>
                        <#list userPosts as p>
                            <div class="post-content">

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
                                            <p>${p.postText}</p>
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
