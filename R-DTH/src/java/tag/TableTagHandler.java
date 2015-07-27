/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.util.Vector;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Minh-IT
 */
public class TableTagHandler extends SimpleTagSupport {

    private Vector data;
    private Vector column;
    private boolean edit;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        String id = "";
        try {
            StringBuffer buff = new StringBuffer();
            buff.append("<table class='mdl-data-table mdl-js-data-table'>");
            buff.append("<tr>");
            for (Object c : column) {
                buff.append("<th>");
                buff.append(c);
                buff.append("</th>");
            }
            buff.append("</tr>");

            for (Object tmp : data) {
                buff.append("<tr>");
                Vector vTmp = (Vector) tmp;
                for (Object row : vTmp) {
                    if (row != null) {
                        if (row.toString().length() > 4 && "id://".equals(row.toString().substring(0, 5))) {
                            id = row.toString().substring("id://".length());
                            continue;
                        }
                        if (row.toString().length() > 50) {
                            buff.append("<td><p>" + row.toString().substring(0, 50) + "</p></td>");
                            continue;
                        }
                    }

                    buff.append("<td><p>" + row + "</p></td>");
                }
                if (edit) {
                    buff.append("<td>");
                    buff.append("<button pri='true' itemID=" + id + " class='mdl-button mdl-js-button mdl-js-ripple-effec'>Edit</button>");
                    buff.append("</td>");
                }
                buff.append("</tr>");
            }

            buff.append("</table>");

            out.print(buff.toString());
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in TableTagHandler tag", ex);
        }
    }

    public void setData(Vector data) {
        this.data = data;
    }

    public void setColumn(Vector column) {
        this.column = column;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

}
