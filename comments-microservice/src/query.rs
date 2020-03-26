use std::error::Error;
use uuid::Uuid;

use crate::comment::Comment;

pub trait Query {
    // Todo: Return iterator rather than vector
    // Todo: Make async
    fn get_comments_on_post(&self, post_id: &Uuid) -> Result<Vec<Comment>, Box<dyn Error>>;
}