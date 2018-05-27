create table todos
(
  id         INTEGER primary key autoincrement,
  memo       TEXT default "" not null,
  completed  BOOL default FALSE not null,
  expired_at timestamp not null
);
create index todos_completed_index on todos (completed);
create index todos_expired_at_index on todos (expired_at);

