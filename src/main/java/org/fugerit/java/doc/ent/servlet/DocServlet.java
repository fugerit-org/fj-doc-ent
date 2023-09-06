package org.fugerit.java.doc.ent.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fugerit.java.core.log.LogFacade;
import org.fugerit.java.core.web.log.helpers.LogObjectServlet;
import org.fugerit.java.core.web.servlet.config.ConfigContext;
import org.fugerit.java.core.xml.dom.DOMIO;
import org.fugerit.java.doc.base.config.DocConfig;
import org.fugerit.java.doc.ent.config.DocServletConfig;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DocServlet extends LogObjectServlet {

	/*
	 * 
	 */
	private static final long serialVersionUID = -3048440498921813465L;

	/* (non-Javadoc)
	 * @see org.opinf.jlib.ent.servlet.filter.HttpFilter#init(javax.servlet.FilterConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init( config );
		this.logInit( "start : "+DocConfig.VERSION );
		String skipInit = config.getInitParameter( "skip-init" );
		if ( "true".equalsIgnoreCase(skipInit) ) {
			this.logInit( "docservlet init skip "+skipInit );
		} else {
			try {
				String configPath = config.getInitParameter( "config" );
				File configFile = new File( config.getServletContext().getRealPath( "/" ), configPath );
				Document doc = DOMIO.loadDOMDoc( configFile );
				Element root = doc.getDocumentElement();
				DocRequestFacade configFacade = new DocRequestFacade();
				configFacade.configure( root , new ConfigContext( config.getServletContext() ) );
				this.getServletContext().setAttribute( DocServletConfig.ATT_NAME_DOCFACADE , configFacade );
			} catch (Throwable t) {
				LogFacade.handleError( t );
			}			
		}		
		this.logInit( "end" );
	}	

	private void handleFacade( HttpServletRequest request, HttpServletResponse response ) {
		try {
			DocRequestFacade facade = (DocRequestFacade)this.getServletContext().getAttribute( DocServletConfig.ATT_NAME_DOCFACADE );
			facade.handleDoc(request, response);
			response.sendError( HttpServletResponse.SC_INTERNAL_SERVER_ERROR );
		} catch ( Exception ex ) {
			this.getLogger().error( "Error "+ex, ex );
			try {
				response.sendError( HttpServletResponse.SC_INTERNAL_SERVER_ERROR );
			} catch (Exception e ) {
				this.getLogger().error( "Fatal error, failed to send error 500 "+e, e );
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.handleFacade(request, response);
	}
	
	/* (non-Javadoc)
	 * @see org.opinf.jlib.ent.servlet.filter.HttpFilter#doFilter(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.handleFacade(request, response);
	}
	
}
