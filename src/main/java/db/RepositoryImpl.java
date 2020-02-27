package db;

public class RepositoryImpl implements Repository {

	public Entity save(Entity entity) {
		System.out.println(SqlBuilder.save(entity));
		return null;
	}
}
