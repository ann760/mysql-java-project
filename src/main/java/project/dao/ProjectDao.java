package project.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import provided.util.DaoBase;
import project.exception.DbException;


public class ProjectDao extends DaoBase {
	public void executeBatch(List<String> sqlBatch) {
		try(Connection conn = DbConnection.getConnection()){
			startTransaction(conn);
			
			try(Statement stmt = conn.createStatement()){
				for(String sql : sqlBatch) {
					stmt.addBatch(sql);
				}
				stmt.executeBatch();
				commitTransaction(conn);
			}
			catch (Exception e) {
				rollbackTransaction(conn);
				throw new DbException(e);
			}
		} catch (SQLException e) {
			throw new DbException(e);
		}
	}
}
