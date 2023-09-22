SELECT
    EXTRACT(HOUR FROM created_at) AS accident_hour,
    COUNT(*) AS accident_count
FROM reports
WHERE title = 'accident'
GROUP BY accident_hour
ORDER BY accident_count DESC
LIMIT 1;