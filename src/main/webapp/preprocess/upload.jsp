<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 

<body>

	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">本地文件上传到HDFS</div>  
	<br>
	<div style="padding-left: 30px;font-size: 15px;padding-top:10px;"><br>
		如果打开了MR任务监控页面，请先关闭，再提交本次MR任务。输入路径请输入文件的完整路径。<br>
	</div>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text"
					id="localFileId" data-options="required:true" style="width:300px" />
				</td>

			</tr>
			<tr>
				<td></td>
				<td><a id="uploadId" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">上传</a></td>
			</tr>

		</table>
	
	</div> 
 
	<script type="text/javascript" src="js/preprocess.js"></script>  

</body>

