<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!--登录用到的div 还有引用的样式和js在上面有写-->
<div id="fullbg"></div>
<div id="login">
  <p class="close">
    <a href="javascript:closeLogin();"> x </a>
  </p>
  <section class="aui-page-panel-content">
    <h2>Log in to [Java repository]</h2>
    <form action="#" method="post" id="d" class="aui top-label">
      <fieldset>
        <div class="field-group">
          <label for="d-fname">Username</label> <input
            class="text long-field" type="text" id="d-fname" name="d-fname"
            title="first name">
        </div>
        <div class="field-group">
          <label for="d-fname">Password</label> <input
            class="text long-field" type="text" id="d-fname" name="d-fname"
            title="first name">
        </div>
        <div class="checkbox">
          <input class="checkbox" type="checkbox" name="cbThree" id="cbThree">
          <label for="cbThree">Remember me on this computer</label>
        </div>
        <div class="field-group">
          <label for="d-fname">Don't have an account? <a href="#">
              Sign up for one </a></label>
        </div>
      </fieldset>
      <div class="buttons-container">
        <div class="buttons">
          <input class="aui-button aui-button-primary" type="submit"
            id="submit" name="submit" value="Log in"> <a id="cancel"
            class="aui-button aui-button-link" name="cancel" accesskey="c"
            href="#"> Can't access your account? </a>
        </div>
      </div>
    </form>
  </section>
  <!--.aui-page-panel-content-->
</div>
<!--#login-->