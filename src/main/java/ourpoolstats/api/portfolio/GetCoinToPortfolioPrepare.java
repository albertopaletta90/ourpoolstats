package ourpoolstats.api.portfolio;

import java.util.List;

import org.springframework.http.ResponseEntity;

import ourpoolstats.mapper.PortfolioMapper;
import ourpoolstats.model.Portfolio;
import ourpoolstats.query.QueryPortfolio;
import ourpoolstats.response.ResponsePortfolio;
import ourpoolstats.response.status.PortofolioResponseStatus;
import ourpoolstats.utility.connection.SetConnection;

public class GetCoinToPortfolioPrepare {

	public ResponseEntity<ResponsePortfolio> getCoinToPortfolio(String username) {
		ResponsePortfolio responsePortfolio = new ResponsePortfolio();
		try {
			List<Portfolio>list = SetConnection.getInstance().getJdbcTemplate().query(QueryPortfolio.getInstance().getGetPortfolioUser(), new PortfolioMapper(),username);
			if(list.isEmpty())
				return new PortofolioResponseStatus().listNotFound(responsePortfolio);
			if(list.get(0).getUserType().equals("MASTER")) {
				List<Portfolio>listPartecipant = SetConnection.getInstance().getJdbcTemplate().query(QueryPortfolio.getInstance().getGetPortfolioPartecipant(), new PortfolioMapper(),list.get(0).getUsername());
				return new PortofolioResponseStatus().succes(responsePortfolio, list, listPartecipant);
			}
			return new PortofolioResponseStatus().succes(responsePortfolio,list,null);
		}catch (Exception e) {
			return new PortofolioResponseStatus().error(responsePortfolio, e);
		}
		
	}
}
