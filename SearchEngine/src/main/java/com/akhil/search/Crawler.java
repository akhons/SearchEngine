package com.akhil.search;


	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	import jakarta.servlet.http.HttpSession;

	import java.io.IOException;
	import java.io.PrintWriter;


import org.jsoup.Jsoup;
	import org.jsoup.nodes.Document;
	import org.jsoup.nodes.Element;
	import org.jsoup.select.Elements;


import com.akhil.store.WriteToDatabase;




	/**
	 * Servlet implementation class WebCrawler
	 */
	public class Crawler extends HttpServlet {
		protected static String url;
		protected static String textData ;
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try{ url = request.getParameter("url");
				setUrl(url);
			 String variable = request.getParameter("searchData");
			 	
			Document doc =  Jsoup.connect(url).get();
			setTextData(doc.text());
			//Elements links = doc.select("a");
			//PrintWriter pw = response.getWriter();
			String textData = doc.text();
			
			//write data to databse using hibernate
			try {
			WriteToDatabase wr = new WriteToDatabase();
			wr.writeToDatabase(url, textData);}
			catch(Exception e) {
				e.printStackTrace();
			}
			HttpSession session = request.getSession();
			session.setAttribute("textdata", textData);
			session.setAttribute("var", variable);
			response.sendRedirect("KeySearch");
			/*for(Element link : links) {
				pw.println(link.attr("href"));
			}*/
			//PrintWriter pw = response.getWriter();
			//pw.println(title);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}

		public String getTextData() {
			return textData;
		}

		public void setTextData(String textData) {
			this.textData = textData;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
		
		
		


	}


