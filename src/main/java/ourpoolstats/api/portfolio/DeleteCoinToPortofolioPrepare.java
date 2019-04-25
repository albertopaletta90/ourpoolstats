package ourpoolstats.api.portfolio;

import org.springframework.http.ResponseEntity;

import ourpoolstats.mapper.PortfolioMapper;
import ourpoolstats.query.QueryPortfolio;
import ourpoolstats.response.ResponsePortfolio;
import ourpoolstats.response.status.PortofolioResponseStatus;
import ourpoolstats.utility.connection.SetConnection;

public class DeleteCoinToPortofolioPrepare {

	public ResponseEntity<ResponsePortfolio> deleteCoinToPortfolio(String name,String username) {
		ResponsePortfolio portfolio = new ResponsePortfolio();
		try {
			int id = SetConnection.getInstance().getJdbcTemplate().query(QueryPortfolio.getInstance().getGetPortfolioUser(), new PortfolioMapper(),username).get(0).getId();
			SetConnection.getInstance().getJdbcTemplate().update(QueryPortfolio.getInstance().getDeleteCoinToPortfolio(),id);
			return new PortofolioResponseStatus().succes(portfolio, null, null);
		} catch (Exception e) {
			return new PortofolioResponseStatus().error(portfolio,e);
		}

	}

}
