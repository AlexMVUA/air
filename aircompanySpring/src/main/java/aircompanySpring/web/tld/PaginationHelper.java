package aircompanySpring.web.tld;


import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
public class PaginationHelper extends SimpleTagSupport {
	
	private String uri;
	private String searchString;
    private int currentPage;
    private int totalPages;
    private int maxLinks = 5;
 
    private Writer getWriter() {
        JspWriter out = getJspContext().getOut();
        return out;
    }
 
    @Override
    public void doTag() throws JspException {
        Writer out = getWriter();
 
        boolean lastPage = currentPage == totalPages;
        int pgStart = Math.max(currentPage - maxLinks / 2, 1);
        int pgEnd = pgStart + maxLinks;
        if (pgEnd > totalPages + 1) {
            int diff = pgEnd - totalPages;
            pgStart -= diff - 1;
            if (pgStart < 1)
                pgStart = 1;
            pgEnd = totalPages + 1;
        }
 
        try {
            out.write("<ul class=\"paginatorList\">");
 
            if (currentPage > 1)
                out.write(constructLink(currentPage - 1, "Previous", "paginatorPrev"));
 
            for (int i = pgStart; i < pgEnd; i++) {
                if (i == currentPage)
                    out.write("<li class=\"paginatorCurr"+ 
                    		(lastPage && i == totalPages ? " paginatorLast" : "")  +"\">"+ currentPage + "</li>");
                else
                    out.write(constructLink(i));
            }
 
            if (!lastPage)
                out.write(constructLink(currentPage + 1, "Next", "paginatorNext paginatorLast"));
 
            out.write("</ul>");
 
        } catch (java.io.IOException ex) {
            throw new JspException("Error in Paginator tag", ex);
        }
    }
 
    private String constructLink(int page) {
        return constructLink(page, String.valueOf(page), null);
    }
 
    private String constructLink(int page, String text, String className) {
        StringBuilder link = new StringBuilder("<li");
        if (className != null) {
            link.append(" class=\"");
            link.append(className);
            link.append("\"");
        }
        link.append(">")
            .append("<a href=\"");
        
        if (searchString != null) {
        	String searchParametrUri = "&&searchString=" + searchString;
        	link.append(uri.replace("&&currentPage=##", searchParametrUri + "&&currentPage=" + String.valueOf(page)));        
        } else {
        	link.append(uri.replace("##", String.valueOf(page)));
        }
        link.append("\">")
            .append(text)
            .append("</a></li>");
        return link.toString();
    }
 
    public void setUri(String uri) {
        this.uri = uri;
    }
 
    public void setCurrentPage(int currPage) {
        this.currentPage = currPage;
    }
 
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    
    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
 
    public void setMaxLinks(int maxLinks) {
        this.maxLinks = maxLinks;
    }	
}
