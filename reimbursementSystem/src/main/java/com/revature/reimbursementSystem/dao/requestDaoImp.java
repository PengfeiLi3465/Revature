package com.revature.reimbursementSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.revature.reimbursementSystem.model.request;
import com.revature.reimbursementSystem.util.ConnectionUtil;

public class requestDaoImp implements requestDao {
	private static requestDao dao = null;
	private static Logger log = LoggerFactory.getLogger(requestDaoImp.class);

	public requestDaoImp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static requestDao getDao() {
		if (dao == null)
			dao = new requestDaoImp();
		return dao;
	}

	@Override
	public request createRequest(request reimbursement) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO public.request (account_id, conditiontype_id, description, amount) VALUES (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, reimbursement.getAccount_id());
			ps.setInt(2, reimbursement.getConditiontype_id());
			ps.setString(3, reimbursement.getDescription());
			ps.setFloat(4, reimbursement.getAmount());
			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int key = rs.getInt("request_id");
			reimbursement.setRequest_id(key);
			log.info("new request inserted");
			return reimbursement;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public request getRequest(int request_id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM public.request WHERE request_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, request_id);

			ResultSet rs = ps.executeQuery();
			rs.next();

			request reimbursement = new request();
			reimbursement.setRequest_id(rs.getInt("request_id"));
			reimbursement.setAccount_id(rs.getInt("account_id"));
			reimbursement.setAmount(rs.getFloat("amount"));
			reimbursement.setConditiontype_id(rs.getInt("conditiontype_id"));
			reimbursement.setDescription(rs.getString("description"));
			reimbursement.setNote(rs.getString("note"));

			log.info("get request by requestId");
			return reimbursement;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<request> getAllRequest() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM public.request";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			List<request> reimbursements = new ArrayList<request>();
			request reimbursement;
			while (rs.next()) {
				reimbursement = new request();
				reimbursement.setRequest_id(rs.getInt("request_id"));
				reimbursement.setAccount_id(rs.getInt("account_id"));
				reimbursement.setAmount(rs.getFloat("amount"));
				reimbursement.setConditiontype_id(rs.getInt("conditiontype_id"));
				reimbursement.setDescription(rs.getString("description"));
				reimbursement.setNote(rs.getString("note"));
				log.info("get all requests");
				reimbursements.add(reimbursement);
			}

			return reimbursements;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public request updateRequest(request reimbursement) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE public.request\r\n" + "	SET conditiontype_id=?, note=?\r\n" + "	WHERE request_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbursement.getConditiontype_id());
			ps.setString(2, reimbursement.getNote());
			ps.setInt(3, reimbursement.getRequest_id());

			if (ps.executeUpdate() > 0) {
				log.info("request updated");
				return reimbursement;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<request> getRequestByAccountId(int accountId) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM public.request WHERE account_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, accountId);
			ResultSet rs = ps.executeQuery();
			List<request> reimbursements = new ArrayList<request>();
			request reimbursement;
			while (rs.next()) {
				reimbursement = new request();
				reimbursement.setRequest_id(rs.getInt("request_id"));
				reimbursement.setAccount_id(rs.getInt("account_id"));
				reimbursement.setAmount(rs.getFloat("amount"));
				reimbursement.setConditiontype_id(rs.getInt("conditiontype_id"));
				reimbursement.setDescription(rs.getString("description"));
				reimbursement.setNote(rs.getString("note"));

				reimbursements.add(reimbursement);
			}

			return reimbursements;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
