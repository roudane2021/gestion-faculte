
interface Page<T> {
    content: T[]; // Data for the current page
    number: number; // Current page number
    size: number; // Number of items per page
    totalPages: number; // Total number of pages
    totalElements: number; // Total number of items across all pages
  }