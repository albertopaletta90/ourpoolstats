package ourpoolstats.api.portfolio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import ourpoolstats.mapper.PortfolioMapper;
import ourpoolstats.mapper.StringMapper;
import ourpoolstats.model.Portfolio;
import ourpoolstats.query.QueryPortfolio;
import ourpoolstats.response.ResponsePortfolio;
import ourpoolstats.response.status.PortofolioResponseStatus;
import ourpoolstats.utility.connection.GetConnection;

public class GetCoinToPortfolioPrepare {

	public ResponseEntity<ResponsePortfolio> getCoinToPortfolio(String username) {
		ResponsePortfolio responsePortfolio = new ResponsePortfolio();
		try {
			String type = GetConnection.getInstance().getJdbcTemplate().query(QueryPortfolio.getInstance().getGetType(), new StringMapper(),username).get(0);
			List<Portfolio>list = new ArrayList<>();
			List<Portfolio>listPartecipant = new ArrayList<>();

			if(type.equals("MASTER")) {
				list = GetConnection.getInstance().getJdbcTemplate().query(QueryPortfolio.getInstance().getGetPortfolioUser(), new PortfolioMapper(),username);
				listPartecipant = GetConnection.getInstance().getJdbcTemplate().query(QueryPortfolio.getInstance().getGetPortfolioPartecipant(), new PortfolioMapper(),username);
				return new PortofolioResponseStatus().succes(responsePortfolio, list, listPartecipant);

			}else if(type.equals("USER")) {
				list = new ArrayList<Portfolio>();	
				listPartecipant = GetConnection.getInstance().getJdbcTemplate().query(QueryPortfolio.getInstance().getGetPortfolioUser(), new PortfolioMapper(),username);
				return new PortofolioResponseStatus().succes(responsePortfolio,list,listPartecipant);
			}	

			return new PortofolioResponseStatus().listNotFound(responsePortfolio);
			
		}catch (Exception e) {
			return new PortofolioResponseStatus().error(responsePortfolio, e);
		}

	}
}
