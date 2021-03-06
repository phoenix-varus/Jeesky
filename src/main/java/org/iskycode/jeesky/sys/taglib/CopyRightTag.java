package org.iskycode.jeesky.sys.taglib;

import org.iskycode.jeesky.sys.util.Const;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author phoenix
 *
 *         自定义标签-关于页面权限标识
 */
public class CopyRightTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println(Const.COPYRIGHT);
	}
}
