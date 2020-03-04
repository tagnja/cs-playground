#include <stdio.h>
#include <sys/shm.h>
#include <sys/stat.h>

int main()
{
	int segment_id;
	char* shared_memory;
	
	const int size = 4096;
	
	// allocate a shared memory segment
	segment_id = shmget(IPC_PRIVATE, size, S_IRUSR | S_IWUSR);
	
	// attch 
	shared_memory = (char *) shmat(segment_id, NULL, 0);
	
	// write a message to the shared memory segment
	sprintf(shared_memory, "Hi There!");
	
	
	printf("*%s\n", shared_memory);
	
	// detach the shared memory segment
	shmdt(shared_memory);
	
	// reomve the shared memory segment
	shmctl(segment_id, IPC_RMID, NULL);
	
	return 0;
}