package himedia.kdt.myhome.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import himedia.kdt.myhome.vo.UserVo;

public class UserDaoImpl extends BaseDao 
	implements UserDao {

	public UserDaoImpl(String dbUser, String dbPass) {
		super(dbUser, dbPass); 
	}

	@Override
	public List<UserVo> getList() {
		return null;
	}

	@Override
	public boolean insert(UserVo userVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO users " +
				"(name, password, email, gender) " + 
				"VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userVo.getName());
			pstmt.setString(2, userVo.getPassword());
			pstmt.setString(3, userVo.getEmail());
			pstmt.setString(4, userVo.getGender());
			
			insertedCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 1 == insertedCount;
	}

	@Override
	public boolean update(UserVo userVo) {
		return false;
	}

	@Override
	public boolean delete(Integer no) {
		return false;
	}

	@Override
	public UserVo getUserByIdAndPassword(String id, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVo userVo = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT no, name, email, gender " +
					" FROM users " +
					" WHERE email=? AND password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				//	레코드 1개 받아오기
				Integer no = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String gender = rs.getString(4);
				
				userVo = new UserVo(no,
						name, 
						null,
						email,
						gender,
						null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return userVo;
	}
}
