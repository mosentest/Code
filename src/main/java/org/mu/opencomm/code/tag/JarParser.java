package org.mu.opencomm.code.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.mu.opencomm.code.entity.FileInfo;
import org.mu.opencomm.code.entity.JarFile;

public class JarParser extends SimpleTagSupport {

	private JarFile jarFile;
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();

		StringBuilder buffer = new StringBuilder();
		buffer.append("<div class=\"library-panel\"><div class=\"library-title\">");
		buffer.append(String.format("<span>File name: <b>%s</b></div><div class=\"library-content\">", 
				jarFile.getName()));
		parseFileInfo(buffer, jarFile.getContents());
		buffer.append("</div></div>");
		out.println(buffer.toString());
	}
	
	private void parseFileInfo(StringBuilder buffer, List<FileInfo> files) {
		buffer.append("<ul class=\"tree\">");
		for (FileInfo file : files) {
			if (file.isDir()) {
				buffer.append("<li class=\"directory\">");
				buffer.append(file.getName());
				parseFileInfo(buffer, file.getFiles());
				buffer.append("</li>");
			} else {
				buffer.append("<li class=\"" + getClassStyle(file.getExtension()) + "\">");
				buffer.append(file.getName());
				buffer.append("</li>");
			}
		}
		buffer.append("</ul>");
	}
	
	private String getClassStyle(String extension) {
		switch (extension) {
			case "css": case "gif": case "htm": case "ico": case "jar":
			case "java": case "jpg": case "js": case "ppt": case "rar": case "txt":
			case "xml": 
				return extension;
			case "html" :
				return "htm";
			default:
				return "unknown";
		}
	}

	public JarFile getJarFile() {
		return jarFile;
	}

	public void setJarFile(JarFile jarFile) {
		this.jarFile = jarFile;
	}
	
}
