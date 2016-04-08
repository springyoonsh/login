
<form name='frm'>
	<input type="text" name='userId'>
	<input type="text" name='userPw'>
</form>

<input type='button' value='ok' onclick="DB_LOGIN();">

<script>
function DB_LOGIN()
{
	var f = document.frm;
		f.method='get';
		f.action='login_db.do';
		f.submit();
}
</script>
